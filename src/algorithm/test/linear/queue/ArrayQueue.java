package algorithm.test.linear.queue;

/**
 * @author j_cong
 * @date 2017年9月12日
 * @describe 数组实现队列，只能存储int数据
 * @version V1.0.0
 */
public class ArrayQueue {
	
	private int[] mArray;
	private int mCount;
	
	public ArrayQueue(int size) {
		mArray = new int[size];
		mCount = 0;
	}

	//将val添加到队列的末尾
	public void add(int val) {
		mArray[mCount++] = val;
	}
	
	//返回队列开头元素
	public int front() {
		return mArray[0];
	}
	
	//返回队首元素值，并删除
	public int pop() {
		int ret = mArray[0];

		//删除队首元素后，后面的元素顺移
		for (int i = 0; i < mCount; i++) {
			mArray[i] = mArray[i + 1];
		}

        //系统自带的数组复制方法
//		System.arraycopy(mArray, 1, mArray, 0, mArray.length - 1);

        mCount--;

		return ret;
	}
	
	//返回队列的大小
	public int size() {
		return mCount;
	}
	
	//返回队列是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	
}

