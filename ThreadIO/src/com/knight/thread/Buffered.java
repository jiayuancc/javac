package com.knight.thread;
import java.io.*;
public class Buffered{
	
	public static void main(String []args)throws IOException{
		String s=new String("D:/Web/data.txt");
		try{
			write(s);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void write(String path)throws IOException{
		File des=new File(path);
		double point=2.5;
		long number=100L;
		String str="dataform";
		DataOutputStream d=new DataOutputStream(
		new BufferedOutputStream(new FileOutputStream(des))
		);
		d.writeDouble(point);
		d.writeLong(number);
		d.writeUTF(str);
		d.flush();
	}
}



/*
public class Buffered{
	public static void main(String []args) throws IOException{
			File src=new File("D:/Web/c1.css");
			File des=new File("D:/Web/coo.css");
	//		InputStream is=new BufferedInputStream(new FileInputStream(src));
			BufferedReader r=new BufferedReader(new FileReader(src));
			BufferedWriter w=new BufferedWriter(new FileWriter(des));
			String str=null;
			while(null!=(str=r.readLine())){
			System.out.println(str);
			w.write(str);
			w.newLine();
			}
			w.flush();
			r.close();
			w.close();
	}
}
*/