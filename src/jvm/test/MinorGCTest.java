package jvm.test;

/**
 * @author j_cong
 * @date 2017年10月16日
 * @describe 新生代Minor GC测试
 *       VM Args：-verbose:gc -Xms20M -Xmx20M -Xmn10M
 *                -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @version V1.0.0
 */
public class MinorGCTest {

	private static final int _1MB = 1024 * 1024;
	
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[4 * _1MB];   //出现一次Minor GC
	}
	

	public static void main(String[] args) {
		
		MinorGCTest.testAllocation();
	}
}