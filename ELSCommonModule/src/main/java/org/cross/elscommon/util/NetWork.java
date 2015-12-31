package org.cross.elscommon.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWork {
	public static int port = 8885;
	public static String preAddress = "rmi://localhost:";
	
	public static void main(String [] args){
		String ip = null;
		 try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(ip);
	}
}
