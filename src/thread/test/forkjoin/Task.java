package thread.test.forkjoin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟fork-join，任务类
 *
 * @author  j_cong
 * @date    2018/07/24
 * @version V1.0
 */
public class Task {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String name;
    private int price;


}
