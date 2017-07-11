package learning.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class getMyHost {

	public getMyHost() {
		// TODO Auto-generated constructor stub
	}
	
	public void getMyAddress() throws UnknownHostException{
		InetAddress me = InetAddress.getLocalHost();
		String dot = me.getHostAddress();
		String con = me.getCanonicalHostName();
		String host = me.getHostName();
		byte[] byteshow = me.getAddress();
		System.out.println("My getHostAddress :" + dot);
		System.out.println("My CanonicalHostName :" + con);
		System.out.println("My getHostName :" + host);
		for (int i = 0;i < byteshow.length;i++){
			//int unsignedByte = signedByte<0?signedByte+256:signedByte;
			System.out.println("My getHostName :" + byteshow[i]);
		}	
	}
	
	public int getVersion(InetAddress inet){
		byte[] address = inet.getAddress();
		if (address.length == 4)return 1;
		else if (address.length == 16)return 0;
		else return -1;
		
	}
	
	public void  getTypeVersion(String ip) throws UnknownHostException{
		InetAddress add = InetAddress.getByName(ip);
		if (add.isAnyLocalAddress())System.out.println(add+"is wildcard address");
		if (add.isLoopbackAddress())System.out.println(add+"is loopback address");
		
		if (add.isLinkLocalAddress())System.out.println(add+"is link-local address");
		else if (add.isSiteLocalAddress())System.out.println(add+"is site-local address");
		else System.out.println(add+"is global address");
		
		if(add.isMulticastAddress()){
			if (add.isMCGlobal())System.out.println(add+"is global-multicast address");
			else if (add.isMCOrgLocal())System.out.println(add+"is oranization wide multicast address");
			else if (add.isMCSiteLocal())System.out.println(add+"is site wide multicast address");
			else if (add.isMCSiteLocal())System.out.println(add+"is subnet wide multicast address");
			else if (add.isMCNodeLocal())System.out.println(add+"is interface-local multicast address");
			else System.out.println(add+"is unknown muticast address");
		} else {
			System.out.println(add+"is unicast address");
		}
	}
	
	public void getNetInterface() throws SocketException{
		Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
		while (nis.hasMoreElements()){
			NetworkInterface ni = nis.nextElement();
			System.out.println(ni);
		}
	}
}
