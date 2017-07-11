package learning.thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import learning.comm.*;
public class Multithread{
	int[] data = null;
	public static int max(int[] data) throws InterruptedException, ExecutionException{
		if (data.length == 1){
			return data[0];
		}else if (data.length == 0){
			throw new IllegalArgumentException();
		}
	
	
	FindMax task1 = new FindMax(data,0,data.length/2);
	FindMax task2 = new FindMax(data,data.length/2,data.length);
	
	ExecutorService service = Executors.newFixedThreadPool(2);
	Future<Integer> future1 = service.submit(task1);
	Future<Integer> future2 = service.submit(task2);
	
	return Math.max(future1.get(),future2.get());
}
}
class FindMax implements Callable{
	private int[] data;
	private int start;
	private int end;
	
	
	/**
	 * @param data
	 * @param start
	 * @param end
	 */
	public FindMax(int[] data, int start, int end) {
		super();
		this.data = data;
		this.start = start;
		this.end = end;
	}


	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for (int i = start;i<end;i++){
			if (data[i]>max)max = data[i];
		}
		return max;
	}
}
	
