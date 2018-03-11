package jvm.test;

/**
 * @author j_cong
 * @date 2018年2月23日
 * @describe 长期存活的对象进入老年代测试
 *       VM Args：-verbose:gc -Xms20M -Xmx20M -Xmn10M
 *                -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold = 1
 *                -XX:+PrintTenuringDistribution
 * @version V1.0.0
 */
public class TenuringThresholdTest {

	private static final int _1MB = 1024 * 1024;
	
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		//什么时候进入老年代取决于-XX:MaxTenuringThreshold的设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}
	

	public static void main(String[] args) {
		
		TenuringThresholdTest.testTenuringThreshold();
	}
}
