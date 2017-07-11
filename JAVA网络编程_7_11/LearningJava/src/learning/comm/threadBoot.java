package learning.comm;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import javax.xml.bind.DatatypeConverter;

import learning.thread.*;
public class threadBoot {
	byte[] digest = null;
	String filename = null;
	
	public void receiveDigest(byte[] digest){
		this.digest = digest;
		System.out.println(this);
	}
	
	public void caculateDigest(String filename){
		digestTreadRunnable dr = new digestTreadRunnable(filename,this);
		Thread t = new Thread(dr);
		t.setPriority(8);
		t.start();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		for (String fname:args){
			threadBoot calfun = new threadBoot(fname);
			calfun.caculateDigest(fname);
			
		}
		int[] data = new int[1000];
		int count = 0;
		while(count < data.length){
			data[count] = (int) ((Math.random())*10);
		}
		System.out.println(Multithread.max(data ));
		
		for (String fname:args){
			digestTreadRunnable dr = new digestTreadRunnable(fname);
			Thread t = new Thread(dr);
			t.start();
			System.out.println(DatatypeConverter.printHexBinary(dr.getDegist()));
		}
	}

	/**
	 * @param filename
	 */
	public threadBoot(String filename) {
		super();
		this.filename = filename;
	}
	
	/*@Override
	  public String toString(){
		String result = filename + ":";
		if (digest!=null){
			result += DatatypeConverter.printHexBinary(digest);
		}else{
			result += "digst not available";
		}
		return result;
		
	}*/

}




