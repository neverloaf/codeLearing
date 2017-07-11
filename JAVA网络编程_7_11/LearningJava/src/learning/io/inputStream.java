/**
 * 
 */
package learning.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author neverloaf
 *
 */
public class inputStream {

	/**
	 * 
	 */
	public inputStream() {
		// TODO Auto-generated constructor stub
	}
	
	public static void readInputStream(InputStream input){
		System.out.println(input.toString());
		int len = 0;
		try {
			 len = input.available();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		byte[] inputByte = new byte[len-10];
		try {
			int a = input.read(inputByte);
			System.out.println(new String(inputByte));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
