package thread.test;
/**
 * ThreadLocal测试类
 *
 * @author  j_cong
 * @date    2017/10/22
 * @version V1.0
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        Account at = new Account("初始名");

        new MyThread3(at, "线程甲").start();
        new MyThread3(at, "线程乙").start();
    }
}

class Account {

    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String str) {
        this.name.set(str);
        System.out.println("---" + this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }

}

class  MyThread3 extends Thread {

    private Account account;

    public MyThread3 (Account account, String name) {

        super(name);
        this.account = account;
    }


    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
            }
            System.out.println(account.getName() + " 账户的i值："+ i);
        }
    }

}
