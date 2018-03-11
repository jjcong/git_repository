package proxy.test;

/**
 * @author j_cong
 * @date 2017年8月27日
 * @describe 静态代理测试：代理角色定义
 * @version V1.0.0
 */
public class ProxySubject extends BaseSubject {
	//代理角色内部引用了真实角色
	private RealSubject realSubject = new RealSubject();
	
	@Override
	public void request() {
		
		this.preRequest(); //在真实对象之前附件的操作
		
		if (null == realSubject) {
			realSubject = new RealSubject();
		}
		//真实角色所完成的事情
		realSubject.request();
		
		this.postRequest(); //在真实对象之后附件的操作
	}
	
	private void preRequest() {
		System.out.println("pre request");
	}
	 
	private void postRequest() {
		System.out.println("post request");
	}
	 

}
