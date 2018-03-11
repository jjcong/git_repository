package thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author j_cong
 * @date 2017年10月4日
 * @describe 它就是将一组线程的执行结果放入一个BlockQueueing当中。
 *          这里线程的执行结果放入到Blockqueue的顺序只和这个线程的执行时间有关，
 *          和它们的启动顺序无关。并且你无需自己在去写很多判断哪个线程是否执行完成，
 *          它里面会去帮你处理。
 * @version V1.0.0
 */

public class CompletionTest  {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("main Thread begin:");
		
		ExecutorService executor = Executors.newCachedThreadPool();
		//构建完成服务
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
		
		for (int i = 0; i < 10; i++) {
			completionService.submit(new HandlerFuture<Integer>(i));
		}
		
		//一个一个等待返回结果
		for (int i = 0; i < 10; i++) {
			System.out.println("返回结果：" + completionService.take().get());
		} 
		
		System.out.println("main Thread end!");
	}
	

}

@SuppressWarnings("hiding")
class HandlerFuture<Integer> implements Callable<Integer> {

	private Integer num;
	
	public HandlerFuture(Integer num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		Thread.sleep(300);
		System.out.println(Thread.currentThread().getName());
		return num;
	}
	
}
