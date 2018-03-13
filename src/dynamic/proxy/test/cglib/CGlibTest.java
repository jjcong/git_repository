package dynamic.proxy.test.cglib;


/**
 * CGlib 动态代理测试类
 *
 * @author  j_cong
 * @date    2018/03/13
 * @version V1.0
 */
public class CGlibTest {

    public static void main(String[] args) {

        Book book = new Book();

        BookLibProxy cglib = new BookLibProxy(book);

        Book bookCglib = (Book)cglib.getInstance();

        bookCglib.addBook();
    }
}
