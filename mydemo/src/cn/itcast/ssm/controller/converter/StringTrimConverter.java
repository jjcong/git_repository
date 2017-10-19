package cn.itcast.ssm.controller.converter;

import org.springframework.core.convert.converter.Converter;

public class StringTrimConverter implements Converter<String, String>{  
	  
    @Override  
    public String convert(String source) {  
          
        //去掉字符串两边空格，如果去除后为空设置为null  
        if (source!=null) {  
            source = source.trim();  
            if (source.equals("")) {  
                return null;  
            }  
        }  
          
        return source;  
    }  
  
}  
