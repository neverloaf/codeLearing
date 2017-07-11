/**
 * 
 */
package learning.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import learning.comm.threadBoot;

/**
 * @author neverloaf
 *
 */
public class digestTreadRunnable implements Runnable {
	String fname = null;	
	byte[] digest = null;
	private threadBoot callBack;
	/**
	 * 
	 */
	public digestTreadRunnable(String fname) {
		// TODO Auto-generated constructor stub
		this.fname = fname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream fin = new FileInputStream(fname);
			MessageDigest sha = MessageDigest.getInstance("MD5");
			DigestInputStream ds = new DigestInputStream(fin,sha);
			
			while(ds.read()!=-1);
			ds.close();
			digest = sha.digest();
			callBack.receiveDigest(digest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

	/**
	 * @param fname
	 * @param digest
	 */
	public digestTreadRunnable(String fname, threadBoot tb) {
		super();
		this.fname = fname;
		this.callBack = tb;
	}

	public byte[] getDegist() {
		// TODO Auto-generated method stub
		return digest;
	}

}
