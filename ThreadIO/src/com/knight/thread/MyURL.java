package com.knight.thread;
import java.net.*;
import java.io.*;
public class MyURL{
	public static void main(String []args)throws IOException{
	URL url=new URL("http://inankai.cn/new/index.html");
	
	BufferedReader br=
		new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
	BufferedWriter bw=
		new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/inankai.html"),"utf-8"));
	String msg=null;
	while((msg=br.readLine())!=null){
		System.out.println(msg);
		bw.append(msg);
		bw.newLine();
	}
	bw.flush();
	bw.close();
	br.close();
	
	/*
	InputStream is=url.openStream();
	byte []flush=new byte[1024];
	int len=0;
	while(-1!=(len=is.read(flush))){
		String str=new String(flush,0,len);
		System.out.println(str);
	}
	is.close();
	*/
		
	}
}