package com.knight.thread;
import java.util.*;
import java.io.*;
public class SplitFile{
	private String filePath;
	private String fileName;
	private int size;
	private long blockSize;
	private long length;
	private List<String> blockPath;
	
	public SplitFile(){
		blockPath=new ArrayList<String>();
	}
	public SplitFile(String filePath){
		this();
		this.filePath=filePath;
		this.blockSize=1024;
		init();
	}
	public SplitFile(String filePath,long blockSize){
		this();
		this.filePath=filePath;
		this.blockSize=blockSize;
		init();
	}
	public void init(){
		File src=null;
		if(null==filePath||!(((src=new File(filePath)).exists())))
			return;
		if(src.isDirectory())return;
		this.fileName=src.getName();
		long length=src.length();
		if(blockSize>length){
			this.blockSize=length;
		}
		size=(int)Math.ceil(length*1.0/this.blockSize);
		System.out.println(length);
	}
	private void initPathName(){
		for(int i=0;i<size;i++){
			this.blockPath.add(this.fileName+".part"+i);
		}
	}
	
	public void split(String destPath){
		long beginPos=0;
		long actualBlockSize=blockSize;
		for(int i=0;i<size;i++){
			if(i==size-1){
				
			}
			splitDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}
	private void splitDetail(int idx,long begingPos,long actualBlockSize){
		
	}
	
	public static void main(String[]args){
		SplitFile file=new SplitFile("D:/Web/news.txt",1000);
		System.out.println(file.size);
	}
}