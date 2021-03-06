package com.knightsight.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item []q;
	private int size;
	public RandomizedQueue(){
		q=(Item[])new Object[0];
		size=0;
	}
	
	public boolean isEmpty(){
		if(q.length==0)
			return true;
		return false;
	}
	
	public int size(){
		return size;
	}
	public void enqueue(Item item){
		 if(item==null)
			 throw new NoSuchElementException();
		 int length=q.length;
		 if(length==0)
			 resize(1);
		 else if(length<=size)
			 resize(2*length);
		 q[size++]=item;
	}
	
	public Item dequeue(){
		if(isEmpty())
			throw new UnsupportedOperationException();
		int rand=StdRandom.uniform(size);
		q[rand]=q[--size];
		if(size>0&&size<=q.length/4){ 
			resize(q.length/2);
		}
		return q[rand];
	}
	public Item sample(){
		if(isEmpty())
			throw new UnsupportedOperationException();
		int rand=StdRandom.uniform(size);
		return q[rand]; 
		
	}
	private void resize(int n){
		Item[] nq=(Item[])new Object[n];
		for(int i=0;i<size;i++)
			nq[i]=q[i];
		q=nq;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Item>(){
			int first=0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				int index=first++;
				return q[index]!=null;
			}

			@Override
			public Item next() {
				if(first>=size-1)
					throw new NoSuchElementException();
				return q[first++];
			}
			
		};
	}
	
	public static void main(String []args){
		RandomizedQueue<Integer> r=new RandomizedQueue<Integer>();
		for(int i=0;i<1000;i++)
			r.enqueue(i);
		while(r.size()!=1)
			System.out.println(r.dequeue()+" "+r.size());
	}
	
}
