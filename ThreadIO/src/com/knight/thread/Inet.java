package com.knight.thread;
import java.net.*;
public class Inet{
	public static void main(String []args)throws UnknownHostException{
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		addr=InetAddress.getByName("222.30.60.34");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		InetSocketAddress saddr=new InetSocketAddress("222.30.60.34",9999);
		System.out.println(saddr.getHostName());
		System.out.println(saddr.getPort());
		
	}
}