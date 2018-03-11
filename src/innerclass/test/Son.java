package innerclass.test;

/**
 * @author j_cong
 * @date 2017年9月27日
 * @describe 使用内部类实现多继承：儿子类，继承父亲类和母亲类（内部类的形式）
 * @version V1.0.0
 */
public class Son {

	/*
	 * 内部类继承Father类
	 */
	class Father_1 extends Father {
		public int strong() {
			return super.strong() + 1;
		}
	}
	
	/*
	 * 内部类继承Mother类
	 */
	class Mother_1 extends Mother {
		public int kind() {
			return super.kind() - 2;
		}
	}
	
	public int getStrong() {
		return new Father_1().strong();
	}
	
	public int getKind() {
		return new Mother_1().kind();
	}
}
