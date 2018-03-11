package algorithm.test.linear.queue;

public class ArrayQueueTest {
	
	public static void main(String[] args) {
		
		int tmp = 0;
		ArrayQueue queue = new ArrayQueue(12);
		
		queue.add(10);
		queue.add(20);
		queue.add(30);
		
		//将队首元素赋给tmp，并删除
		tmp = queue.pop();
		System.out.println("tmp = " + tmp);
		
		//只将队首元素赋给tmp，不删除
		tmp = queue.front();
		System.out.println("tmp = " + tmp);
		
		queue.add(40);
		
		System.out.println("isEmpty() = " + queue.isEmpty());
		System.out.println("size() = " + queue.size());
		
		while(!queue.isEmpty()) {
			System.out.println("size() = " + queue.pop());
		}
	}

}
