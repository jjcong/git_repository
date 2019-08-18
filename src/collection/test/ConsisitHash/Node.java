package collection.test.ConsisitHash;
/**
 * 基础数据节点
 *
 * @author  j_cong
 * @date    2019/03/01
 * @version V1.0
 */
public class Node {
    public Long key;
    public String value;

    public Node(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node {" +
                "key=" + key +
                ", value=" + value + '\''+ "}";
    }

}
