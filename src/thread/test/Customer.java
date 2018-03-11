package thread.test;
/**
 * @ Author:  j_cong
 * @ Date:    2017-10-21
 * @ Version: V1.0
 * @ Desc:    Ïû·ÑÕß
 */
public class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    public void consume(final int value) {
        new Thread() {
            @Override
            public void run() {
                depot.get(value);
            }
        }.start();

    }
}
