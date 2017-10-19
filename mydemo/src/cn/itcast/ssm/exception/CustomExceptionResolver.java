package cn.itcast.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


//全局异常处理器
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse response, Object hanlder, Exception ex) {
		// handler就是处理器适配器需要执行Handler的对象（只有method方法）
		//解析出异常类型
		//如果该异常类型是系统自定义异常，直接取出异常信息，然后在错误页面展示
		
		
		//如果该异常信息不是系统自定义异常，构造一个自定义的异常类型（信息为“未知错误”）
		
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
		}else{
			customException = new CustomException("未知错误");
		}
		
		//错误信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("message", message);
		
		//指向错误页面
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
