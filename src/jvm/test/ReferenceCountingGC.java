package jvm.test;

/**
 * @author j_cong
 * @date 2017年10月10日
 * @describe 两个对象相互调用，导致内存溢出
 * @version V1.0.0
 */
public class ReferenceCountingGC {

	public Object instance = null;
	
	private static final int _1MB = 1024 * 1024;
	
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void testGC() {
		
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
		
	}
}
