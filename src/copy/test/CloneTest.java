package copy.test;

/**
 * @author j_cong
 * @date 2017年9月27日
 * @describe 深浅拷贝测试
 * @version V1.0.0
 */
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		//正常拷贝
		Student stu1 = new Student(1, "Jack", 24);
		Student stu2 = stu1;
		
		//浅拷贝
		Student stu3 = new Student(1, "Alice", 22);
		Student stu4 = (Student) stu1.clone();
		
		System.out.println("stu1 = " + stu1);
		System.out.println("stu2 = " + stu2);
		System.out.println("stu3 = " + stu3);
		System.out.println("stu4 = " + stu4);
				
	}
}
