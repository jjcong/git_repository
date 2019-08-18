package stream.test;

import design.pattern.decorator.Source;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Java新特性----stream
 *
 * @author  j_cong
 * @date    2019/08/18
 * @version V1.0
 */
public class StreamTest {

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Alice", 10000.0),
            new Employee(2, "Tom", 20000.0),
            new Employee(3, "Jack", 30000.0),
            new Employee(4, "Bob", 40000.0)
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);

    public static void main(String[] args) {

        //将数组转为流的两种方式
        Stream.of(arrayOfEmps);
        empList.stream();

        empList.stream().forEach(employee -> employee.salaryIncrement(1000.0));
        empList.forEach(employee -> System.out.println(employee.toString()));
        Long empCount = empList.stream().filter(employee -> employee.getSalary() >= 20000.0).count();

        System.out.println(empCount);

        // 排序
        List<Employee> result = empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());

        result.forEach(employee -> System.out.println(employee.toString()));

        // map


    }


}
