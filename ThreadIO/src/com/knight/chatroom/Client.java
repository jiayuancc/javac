package com.knight.chatroom;
import java.net.*;
import java.io.*;
/*
 * 输入流与输出流独立
 */
public class Client {
	public static void main(String[] args) throws IOException,UnknownHostException{
		System.out.println("请输入名称");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		if(name.equals("")){
			return;
		}
		Socket client =new Socket("localhost",9900);
		//控制台输入流
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
		
	}
}
