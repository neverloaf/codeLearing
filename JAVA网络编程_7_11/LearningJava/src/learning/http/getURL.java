/**
 * 
 */
package learning.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author neverloaf
 *
 */
public class getURL {
	String url = null;
	/**
	 * 
	 */
	public getURL(String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}

	public void readUrl() throws IOException{
		URL u = new URL(this.url);
		InputStream in = u.openStream();
		BufferedInputStream in1 = new BufferedInputStream(in);
		int c;
		long t_start = System.currentTimeMillis();
		while((c = in1.read())!=-1)System.out.write(c);
		long t_end = System.currentTimeMillis();
		System.out.println(t_end- t_start);
		in1.close();
	}
	
	public void SourceViewer() throws IOException{
		InputStream in = null;
			URL u = new URL(this.url);
			in = u.openStream();
			in = new BufferedInputStream(in);
			Reader r = new InputStreamReader(in);
			int c ;
			while((c = r.read())!=-1){
				System.out.write(c);
			}
			in.close();
		
	}

}
