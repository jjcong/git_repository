package generic.test;
/**
 * 
 * @author j_cong
 * @date 2017年8月26日
 * @describe 泛型方法测试
 * @version V1.0.0
 */
public class GenericFruit {
	class Fruit {
		@Override
		public String toString() {
			return "fruit";
		}
	}
	
	class Apple extends Fruit {
		@Override
		public String toString() {
			return "apple";
		}
	}
	
	class Person {
		@Override
		public String toString() {
			return "person";
		}
	}
	
	class GenericTest<T> {
		public void show_1(T t) {
			System.out.println(t.toString());
		}
		
		public <T> void show_2(T t) {
			System.out.println(t.toString());
		}
		
		public <E> void show_3(E t) {
			System.out.println(t.toString());
	}
}
	
	public static void main(String[] args) {
		GenericFruit gr = new GenericFruit();
		Apple apple = gr.new Apple();
		Person person = gr.new Person();
		GenericTest<Fruit> genericTest = gr.new GenericTest<Fruit>();
		
		genericTest.show_1(apple);
//		genericTest.show_1(people);    //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
		genericTest.show_2(apple);
		genericTest.show_2(person);
		genericTest.show_3(apple);
		genericTest.show_3(person);
	}
	
	
	
}
