package thread.test;
/**
 * @ Author:  j_cong
 * @ Date:    2017-10-21
 * @ Version: V1.0
 * @ Desc:    ЩњВњеп
 */
public class Producer1 {

    private Depot depot;

    public Producer1(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int value) {
        new Thread() {
            @Override
            public void run() {
                depot.put(value);
            }
        }.start();
    }

}