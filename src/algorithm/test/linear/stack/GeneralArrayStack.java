package algorithm.test.linear.stack;

import java.lang.reflect.Array;

/**
 * @author j_cong
 * @date 2017年9月12日
 * @describe 数组实现的栈，能存储任意类型的数据
 * @version V1.0.0
 */
public class GeneralArrayStack<T> {

	private static final int DEFAULT_SIZE = 12;
	private T[] mArray;
	private int count;


	public GeneralArrayStack(Class<T> type) {
		this(type, DEFAULT_SIZE);
	}
	
	public GeneralArrayStack(Class<T> type, int size) {
		mArray = (T[]) Array.newInstance(type, size);
	}
	
	//将val添加到栈中
	public void push(T val) {
		mArray[count++] = val;
	}
	
	//返回栈顶元素值
	public T peek() {
		return mArray[count - 1];
	}
	
	//返回栈顶元素值，并删除栈顶元素
	public T pop() {
		T ret = mArray[count - 1];
		count--;
		return ret;
	}
	
	//返回栈的大小
	public int size() {
		return count;
	}
	
	//返回栈是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//打印栈
	public void PrintArrayStack() {
		if (isEmpty()) {
			System.out.println("Stack is Empty!");
		}
		System.out.println("stack size()=" + size());
		
		int i = size() - 1;
		while(i >= 0) {
			System.out.println(mArray[i]);
			i--;
		}
	}
}
