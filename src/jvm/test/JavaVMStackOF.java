package jvm.test;

/**
 * @author j_cong
 * @date 2017年9月18日
 * @describe JVM内存溢出：栈溢出
 *           VM Args: -Xss128K
 * @version V1.0.0
 */
public class JavaVMStackOF {
	
    private int stackLength = 1;  
    
    public void stackLeak() {  
        stackLength++;  
        stackLeak();  
    }  
  
    public static void main(String[] args) throws Throwable {  
    	
    	JavaVMStackOF oom = new JavaVMStackOF();  
        try {  
            oom.stackLeak();  
        } catch (Throwable e) {  
            System.out.println("stack length:" + oom.stackLength);  
            throw e;  
        }  
    }  

}
