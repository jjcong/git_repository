package cn.itcast.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;


import cn.itcast.ssm.po.Items;

public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		
	    //设置模型数据
		request.setAttribute("itemsList", itemsList);
		//设置转发的视图
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
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
	    
	}

