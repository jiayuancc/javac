package com.knight.thread;
import java.lang.Thread;
public class JoinThread extends Thread{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("yield..."+i);
		}
	}
	public static void main(String args[])throws InterruptedException{
		JoinThread j=new JoinThread();
		Thread th=new Thread(j);
		th.start();
		for(int i=0;i<100;i++){
			if(i%20==0){
				Thread.yield();
			}
			System.out.println("main..."+i);
		}
	}
}