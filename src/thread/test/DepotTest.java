package thread.test;
/**
 * @ Author:  j_cong
 * @ Date:    2017-10-21
 * @ Version: V1.0
 * @ Desc:     condition测试
 */
public class DepotTest {

    public static void main(String[] args) {

        Depot depot = new Depot();

        Producer1 producer = new Producer1(depot);
        Customer  customer = new Customer(depot);

        producer.produce(10);
        customer.consume(5);
        producer.produce(20);
        producer.produce(5);
        customer.consume(35);
    }
}
