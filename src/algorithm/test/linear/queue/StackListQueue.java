package algorithm.test.linear.queue;

import java.util.Stack;

/**
 * @author j_cong
 * @date 2017年9月12日
 * @describe Java的Collection集合中自带的队列LinkedList的示例
 *           用栈实现队列
 * @version V1.0.0
 */
public class StackListQueue<T> {
	
	//向队列添加数据时，将已有的全部数据都移到mIn中，将新添加的数据添加mIn中
	private Stack<T> mIn = null;
	//从队列获取元素时，将已有的全部数据都移到mOut中，返回并删除mOut栈顶元素
	private Stack<T> mOut = null;
	
	private int mCount = 0;
	
	public StackListQueue() {
		mIn = new Stack<T>();
		mOut = new Stack<T>();
		mCount = 0;
	}
	
	private void add(T t) {
		//将已有的全部数据都移到mIn中
		while(!mOut.empty()) {
			mIn.push(mOut.pop());
		}
		//将新添加的数据添加到mIn中
		mIn.push(t);
		mCount++;
	}
	
	private T get() {
		//将已有的全部数据都移到mOut中
		while(!mIn.empty()) {
			mOut.push(mIn.pop());
		}
		mCount--;
		return mOut.pop();
	}
	
	private int size() {
		return mCount;
	}
	
	private boolean isEmpty() {
		return mCount == 0;
	}
	
	
	
	public static void main(String[] args) {
		
		StackListQueue<Integer> slist = new StackListQueue<>();
		
		slist.add(10);
		slist.add(20);
		slist.add(30);
		
		System.out.println("isEmpty() = " + slist.isEmpty());
		System.out.println("size() = " + slist.size());
		while(!slist.isEmpty()) {
			System.out.println(slist.get());
		}
	}
}
