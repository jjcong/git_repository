package cn.itcast.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.validation.ValidGroup1;


@Controller

@RequestMapping("/items")
public class ItemsController {
	@Autowired 
	private ItemsService itemsService;
	
	//商品分类
	//itemtypes表示将方法返回值放在request中的key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes() {
		Map<String, String> itemTypes = new HashMap<String, String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "运动");
		itemTypes.put("103", "娱乐");
		itemTypes.put("104", "时尚");
		
		
		return itemTypes;
	}
	//商品查询
		@RequestMapping("/queryItems")
		public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo, HttpServletResponse response) throws Exception {
			
			
			
//			response.setContentType("text/html;charset=utf-8");
			
			//获取客户端的IP地址
		    String addr = request.getRemoteAddr();
		    System.out.println("IP：" + addr);
		    //获取客户端的请求方式
		    System.out.println("请求方式：" + request.getMethod());
		    //获取名为User-Agent的请求头
		    String userAgent = request.getHeader("User-Agent");
		    System.out.println(userAgent);
		    if (userAgent.toLowerCase().contains("chrome")) {
		    	System.out.println("您使用的是谷歌浏览器");
		    } else if (userAgent.toLowerCase().contains("firefox")) {
		    	System.out.println("您使用的是火狐浏览器");
		    } else if (userAgent.toLowerCase().contains("msie")) {
		    	System.out.println("您使用的是微软浏览器");
		    }
		    
		    
		    
			List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("itemsList", itemsList);
		    modelAndView.setViewName("items/itemsList");
		    
		    return modelAndView; 
		}
		 
		
		//商品信息的修改页面提示
		@RequestMapping(value="/editItems", method={RequestMethod.POST, RequestMethod.GET})
		  public String editItems(Model model, @RequestParam(value="id") Integer items_id) throws Exception {
			  
		   ItemsCustom itemsCustom = itemsService.findItemsById(items_id);  
		   //判断商品信息是否为空，根据id没有查到商品，提示用户商品信息不存在
		   if (itemsCustom == null) {
			   throw new CustomException("商品信息不存在!");
		   }
//		   ModelAndView modelAndView = new ModelAndView();
//		   modelAndView.addObject("itemsCustom", itemsCustom);
//		   modelAndView.setViewName("items/editItems");
		   
		   model.addAttribute("items", itemsCustom);
		   
		   return "items/editItems";   
			  
		  }
		
		
		
		//查询商品信息，输出json，RESTful风格
		//将/itemsView/{id}里面的{id}表示将这个位置的参数传到@ParamVariable指定的名称中
		@RequestMapping("/itemsView/{id}")
		public @ResponseBody ItemsCustom itemsCustom(@PathVariable("id") Integer id) throws Exception {
			
			//调用service查询商品信息
			ItemsCustom itemsCustom = itemsService.findItemsById(id);
			
			return itemsCustom;
		}
		
		
		//商品信息修改的提交
		//在需要校验的pojo前面添加@Validated，在需要校验的pojo后边添加BindingResult bindingResult接收校验出错信息
		//注意：@Validated和BindingResult bindingResult是配对出现的，并且顺序也是固定的
		//@ModelAttribute可以指定pojo回显页面在request中的key
		@RequestMapping("/editItemsSubmit")
		public String editItemsSubmit(Model model, HttpServletRequest request,  Integer id, @ModelAttribute("items") @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom, 
				                      BindingResult bindingResult, MultipartFile items_pic, HttpServletResponse response) throws Exception {
//			 response.setContentType("text/html;charset=utf-8");
//			 request.setCharacterEncoding("UTF-8");
			//获取校验错误信息
			if (bindingResult.hasErrors()) {
				//输出错误信息
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				
				for (ObjectError objectError:allErrors) {
					System.out.println(objectError.getDefaultMessage());
				}
				//将错误信息传到页面
				model.addAttribute("allErrors", allErrors);
				
//				//最简单的回显方法
//				model.addAttribute("items", itemsCustom);
				
//				如果出错重新进入商品修改页面
				return "items/editItems";
			}
			
			//上传图片的原始名称
			String originalFilename = items_pic.getOriginalFilename();
			//上传图片
			if (items_pic != null && originalFilename != null && originalFilename.length() > 0) {
				//存储图片的物理路径
				String pic_path = "E:\\1\\image\\";
				//生成新的图片名称
				String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf(".")); 
				//新图片
				File newFile = new File(pic_path + newFilename);
				//将内存中的数据写入磁盘
				items_pic.transferTo(newFile);			
				//上传成功后，将新图片的名称写到itemsCustom中
				itemsCustom.setPic(newFilename);
			}  
			
			//调用service更新商品信息，页面需要将商品信息传到此方法
			itemsService.updateItems(id, itemsCustom);
			
//			ModelAndView modelAndView = new ModelAndView();
//			//返回一个成功页面
//			modelAndView.set ViewName("success");
			
			//重定向到商品查询列表
//			return "redirect:queryItems.action";
		 
			//页面转发
			return "forward:queryItems.action"; 
//			  return "items/editItems";  
		}
		
		//批量删除商品信息
		@RequestMapping("/deleteItems")
		public String deleteItems(Integer[] items_id) throws Exception {
			
			//调用service批量删除商品
			if (null != items_id) {
				itemsService.deleteItemsByLists(items_id);
			}
			
			return "forward:queryItems.action";
		}
		
		//批量修改商品信息页面，将商品信息查询出来，在页面中显示 
		@RequestMapping("/editItemsQuery")
		public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
			
			List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("itemsList", itemsList);
			modelAndView.setViewName("items/editItemsQuery");
			
			return  modelAndView;
			
		} 
		
		
		//批量修改商品信息提交
		@RequestMapping("/editItemsAllSubmit")
		public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
			
			return "success";
		}
		
		//添加商品
		@RequestMapping("/insertItems")
		public String insertItems() throws Exception {
			
			//返回到自定义的添加商品页面(insertItems.jsp)
			return "items/inserItems";
		}
		
		//商品添加的提交选项
	   @RequestMapping(value="/insertItemsSubmit", method={RequestMethod.POST, RequestMethod.GET})
	   public String insertItemsAllSubmit(@Validated ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
		  
		   //insert语句不需要传入id
		   itemsService.insertItems(itemsCustom);
		   
		   //y页面重定向，request数据不可以共享，页面跳转
//		   return forward:queryItems.action";
		   
		   //页面转发，request数据可以共享，页面不跳转
		   return "forward:queryItems.action";
				}
		
}
