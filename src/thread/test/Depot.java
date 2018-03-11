package thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author:  j_cong
 * @ Date:    2017-10-21
 * @ Version: V1.0
 * @ Desc:    �߳�ͬ����condition�����Ĳ���
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
                + "---Ҫ���������" + value + ";;ʵ�����������" + inc
                + ";;�ֿ����������" + depotSize + ";;û�����������" + left);

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
                        + "---Ҫ���������" + value + ";;ʵ�����������" + dec
                        + ";;�ֿ����������" + depotSize + ";;û�����������" + left);

                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
}

}
