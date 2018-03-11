package jvm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author j_cong
 * @date 2017年9月18日
 * @describe JVM内存溢出：堆溢出测试
 *           参数设置：-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * @version V1.0.0
 */
public class HeapOOM {
		  
	    static class OOMObject {  
	    }  
	  
	    public static void main(String[] args) {  
	    	
	        List<OOMObject> list = new ArrayList<>();
	          
	        while (true) {
	        	list.add(new OOMObject());
	        }
//	        while (true) {  
//	            list.add(new OOMObject());  
//	            System.out.println("total(k):"+Runtime.getRuntime().totalMemory()/1024+ 
//	                    "  freeMemory(k):"+Runtime.getRuntime().freeMemory()/1024+ 
//	                    "  maxMemory(k):"+Runtime.getRuntime().maxMemory()/1024+ 
//	                    "  availableProcessors:"+Runtime.getRuntime().availableProcessors());  
//	        }  
	    }  

}
