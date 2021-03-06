package com.knightsight.deque;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{
	private Node<Item> first;
	private Node<Item> last;
	public Deque(){
		this.first=null;
		this.last=null;
	}
	public class Node<Item>{
		Node<Item> previous;
		Node<Item> next;
		Item item;
		public Node(Item item,Node<Item> previous,Node<Item> next){
			this.item=item;
			this.previous=previous;
			this.next=next;
			
		}
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Item>(){
			Node<Item> cur=first;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return cur.next!=null;
			}

			@Override
			public Item next() {
				if(cur.next==null)
					throw new java.util.NoSuchElementException();
				// TODO Auto-generated method stub
				Item temp=cur.item;
				cur=cur.next;
				return temp;
			}
		};
	}
	
	public boolean isEmpty(){
		return first==null&&last==null;	
	}
	public int size(){
		if(isEmpty())
			return 0;
		int count=0;
		for(Item i:this)
			count++;
		return count;
	}
	
	public void addFirst(Item item){
		if(isEmpty()){
			Node<Item> node=new Node<Item>(item,null,null);
			first=node;
			last=node;
			return;
		}
			
		Node<Item> oldFirst=first;
		first=new Node<Item>(item,null,oldFirst);
		oldFirst.previous=first;
	}
	
	public void addLast(Item item){
		if(isEmpty()){
			Node<Item> node=new Node<Item>(item,null,null);
			first=node;
			last=node;
			return;
		}
		Node<Item> oldLast=last;
		last=new Node<Item>(item,oldLast,null);
		oldLast.next=last;
	}
	
	public Item removeFirst(){
		if(isEmpty()){
			throw new UnsupportedOperationException();
		}
		Item temp=first.item;
		first=first.next;
		if(first==null){
			last=null;
		}else{
			first.previous=null;
		}
		return temp;
	}
	
	
	public Item removeLast(){
		if(isEmpty()){
			throw new UnsupportedOperationException();
		}
		Item temp=last.item;
		last=last.previous;
		if(last==null){
			first=null;
		}else{
			last.next=null;
		}
		return temp;
	}
	
	public static void main(String []args){
		Deque<Integer> dq=new Deque<Integer>();
		dq.addFirst(1);
		dq.addFirst(2);
		dq.addFirst(3);
		System.out.println(dq.removeFirst());
		
	}
}
