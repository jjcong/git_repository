package cn.itcast.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import cn.itcast.ssm.po.Items;



@Controller
public class ItemsController3 {
	
	//商品查询列表
	@RequestMapping("/queryItems5")
	public ModelAndView queryItems() throws Exception {
		
		List<Items> itemsList = new ArrayList<Items>();
		
		Items items_1 = new Items();
		items_1.setName("戴尔笔记本");
		items_1.setPrice(8000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("Dell");
		
		Items items_2 = new Items(); 
		items_2.setName("苹果笔记本");
		items_2.setCreatetime(new Date());
		items_2.setPrice(9000f);
		items_2.setDetail("Apple");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
	    modelAndView.setViewName("items/itemsList");
	    
	    
	    return modelAndView; 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		List<Items> itemsList = new ArrayList<Items>();
//		
//		Items items_1 = new Items();
//		items_1.setName("戴尔笔记本");
//		items_1.setPrice(8000f);
//		items_1.setCreatetime(new Date());
//		items_1.setDetail("Dell");
//		
//		Items items_2 = new Items();
//		items_2.setName("苹果笔记本");
//		items_2.setCreatetime(new Date());
//		items_2.setPrice(9000f);
//		items_2.setDetail("Apple");
//		
//		itemsList.add(items_1);
//		itemsList.add(items_2);
//		
//		
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("itemsList", itemsList);
//	    modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
//	    
//	    
//	    return modelAndView;
	    
//	}

}
