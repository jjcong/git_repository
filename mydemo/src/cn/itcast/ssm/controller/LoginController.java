package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {
	
	//登录
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password) throws Exception {
		//调用servce进行用户身份验证
		
		session.setAttribute("username", username);
		
		 return "redirect:/items/queryItems.action";
	}
	
	//退出
	@RequestMapping("/loginout")
	public String logout(HttpSession session) throws Exception {
		//清除session
		session.invalidate();
		
		 return "redirect:/items/queryItems.action";
	}

	
	
}
