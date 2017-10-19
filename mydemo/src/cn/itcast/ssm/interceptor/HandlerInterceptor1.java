package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor {

	//进入Handler方法之前执行
	//用于身份认证、身份授权
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// false表示拦截，不向下执行
		// true表示执行 
		System.out.println("HandlerInterceptor1.....preHandle");
		return true;
	}

	//进入Handler方法之后执行，返回ModelAndView之前执行。也可以在这里统一指定视图
	//将公用的模型数据在这里传到视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		System.out.println("HandlerInterceptor1.....postHandle");
	}

	
	//执行Handler完成执行方法
	//统一的异常处理，统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		System.out.println("HandlerInterceptor1.....afterCompletion");
	}

}
