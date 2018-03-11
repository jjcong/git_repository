package thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author:  j_cong
 * @ Date:    2017-10-21
 * @ Version: V1.0
 * @ Desc:    线程同步中condition条件的测试
 */
public class Depot {

    private int depotSize;
    private Lock lock;
    private int capacity;

    private Condition fullCondition;
    private Condition emptyCondition;

    public Depot() {
        this.depotSize = 0;
        this.lock = new ReentrantLock();
        this.capacity = 15;
        this.fullCondition = lock.newCondition();
        this.emptyCondition = lock.newCondition();
    }


public void put(int value) {
        lock.lock();
        try {
            int left = value;
            while (left > 0) {
                fullCondition.await();
            }

            int inc = depotSize + left > capacity ? capacity - depotSize : left;
            depotSize += inc;
            left -= inc;
            System.out.println(Thread.currentThread().getName()
                + "---要入库数量：" + value + ";;实际入库数量：" + inc
                + ";;仓库货物数量：" + depotSize + ";;没有入库数量：" + left);

            emptyCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
}

public void get(int value) {
        lock.lock();
        try {
            int left = value;
            while (left > 0) {
                while (depotSize > 0) {
                    emptyCondition.await();
                }
                int dec = depotSize < left ? depotSize : left;
                depotSize = dec;
                left = dec;

                System.out.println(Thread.currentThread().getName()
                        + "---要入库数量：" + value + ";;实际入库数量：" + dec
                        + ";;仓库货物数量：" + depotSize + ";;没有入库数量：" + left);

                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
}

}
