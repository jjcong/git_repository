package design.pattern.bridge;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 桥接模式：接口实现类
 * @version V1.0.0
 */
public class SourceSub2 implements Sourceable {

	@Override
	public void method() {
		System.out.println("This is the second sub!");
	}

}
