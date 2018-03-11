package design.pattern.bridge;

/**
 * @author j_cong
 * @date 2017年8月29日
 * @describe 桥接模式：Sourceable的一个抽象实例桥
 * @version V1.0.0
 */
public abstract class BaseBridge {
	
	private Sourceable source;
	
	public void method() {
		source.method();
	}
	
	public Sourceable getSource() {
		return source;
	}
	
	public void setSource(Sourceable source) {
		this.source = source;
	}

}
