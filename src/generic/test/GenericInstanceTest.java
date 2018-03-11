package generic.test;

/**
 * 
 * @author j_cong
 * @date 2017年8月25日
 * @describe 泛型实例测试
 * @version V1.0.0
 * @param <T>
 */
public  class GenericInstanceTest<T> {

	public T obj;
	
	public  GenericInstanceTest(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public void showType() {
		System.out.println("T的实际类型是: " + obj.getClass().getName());  
	}
	
	
	public static void main(String[] args) {
		
		GenericInstanceTest<Integer> intOb = new GenericInstanceTest<Integer>(100); 
		
        intOb.showType();  
        System.out.println("value= " + intOb.getObj());  
        System.out.println("----------------------------------");  
  
        GenericInstanceTest<String> strOb = new GenericInstanceTest<>("Hello World！");  
        strOb.showType();  
        System.out.println("value= " + strOb.getObj()); 
		
	}
	

}
