package design.pattern.memento;

/**
 * @author j_cong
 * @date 2017年8月30日
 * @describe 备忘录模式：保存一个对象的某个状态，以便在适当的时候恢复对象
 * @version V1.0.0
 */
public class MementoTest {
	
	public static void main(String[] args) {
		//创建原始类
		Original original = new Original("egg");
		
		//创建备忘录
		Storage storage = new Storage(original.createMemento());
		
		//修改原始类的状态
		System.out.println("初始状态为：" + original.getValue());
		original.setValue("niu");
		System.out.println("修改后的状态为：" + original.getValue());
		
		//回到原始类的状态
		original.restoreMemento(storage.getMemento());
		System.out.println("恢复后的装态为：" + original.getValue());
	}
}
