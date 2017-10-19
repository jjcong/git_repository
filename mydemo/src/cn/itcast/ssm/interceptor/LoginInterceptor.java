package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	//进入Handler方法之前执行
	//用于身份认证、身份授权
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// false表示拦截，不向下执行
		// true表示执行 
		
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开地址（实际开发时，地址配置在配置文件中）
		if (url.indexOf("login.action") >= 0) {
			return true;
		}
		
		//判断session
		HttpSession session = request.getSession();
		//从session中取出用户身份信息
		String username = (String) session.getAttribute("username");
		
		if (username != null) {
			return true;
		}
		
		//执行这里表示用户身份需要认证，跳转到登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	//进入Handler方法之后执行，返回ModelAndView之前执行。也可以在这里统一指定视图
	//将公用的模型数据子在这里传到视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1.....postHandle");
	}

	
	//执行Handler完成执行方法
	//统一的异常处理，统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HandlerInterceptor1.....afterCompletion");
	}

}
