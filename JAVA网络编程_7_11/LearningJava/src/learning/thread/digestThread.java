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

/**
 * @author neverloaf
 *
 */
public class digestThread extends Thread{
	String filename = null;
	/**
	 * ÕªÒªÏß³Ì
	 */
	public digestThread(String filename) {
		// TODO Auto-generated constructor stub
		this.filename = filename;
	}
	
	@Override
	public void run(){
		try {
			FileInputStream fin = new FileInputStream(this.filename);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(fin, md);
			
			while(din.read()!=-1);
			din.close();
			byte[] digest = md.digest();
			
			StringBuilder ouput = new StringBuilder(filename);
			ouput.append(":");
			ouput.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(ouput);
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

}
