package learning.comm;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import learning.network.getMyHost;

public class netWorkBoot {

	public netWorkBoot() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws UnknownHostException, SocketException {
		// TODO Auto-generated method stub
		getMyHost gM = new getMyHost();
		//gM.getMyAddress();
		gM.getNetInterface();
	}

}
