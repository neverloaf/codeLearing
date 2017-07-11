package learning.comm;
import java.io.IOException;

import learning.http.*;
public class httpBoot {

	public httpBoot() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getURL gU = new getURL("https://www.baidu.com/");
		gU.SourceViewer();
	}

}
