package com.knightsight.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
	private boolean []stat;
    private WeightedQuickUnionUF grid;
    private WeightedQuickUnionUF gridWith0;
    private int n;
	public Percolation(int n){
		this.n=n;
		if(n<=0)
			throw new IllegalArgumentException("Argument Illegal");
		stat=new boolean[n*n+1];
		for(int i=1;i<=n*n;i++)
			stat[i]=false;
		grid=new WeightedQuickUnionUF(n*n+2);
		gridWith0=new WeightedQuickUnionUF(n*n+1);
	}
	
	private boolean isBottom(int i,int j){
		return xyTo1d(i, j)<=n*n&&xyTo1d(i, j)>n*(n-1);
	}
	
	private boolean isTop(int i,int j){
		return xyTo1d(i, j)<=n;
	}
	
	private int xyTo1d(int i,int j){
		if(i<=0||i>n){
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
		if(j<=0||j>n){
			throw new IndexOutOfBoundsException("row index j out of bounds");
		}
		return (i-1)*n+j;
	}
	

	public void open(int i, int j) {
		int index=xyTo1d(i, j);
		stat[index]=true;
		if(j!=1&&isOpen(i,j-1)){
			grid.union(xyTo1d(i, j), xyTo1d(i, j-1));
			gridWith0.union(xyTo1d(i, j), xyTo1d(i, j-1));
		}
		if(j!=n&&isOpen(i,j+1)){
			grid.union(xyTo1d(i, j), xyTo1d(i, j+1));
			gridWith0.union(xyTo1d(i, j), xyTo1d(i, j+1));
		}
		if(i!=1&&isOpen(i-1,j)){
			grid.union(xyTo1d(i, j), xyTo1d(i-1, j));
			gridWith0.union(xyTo1d(i, j), xyTo1d(i-1, j));
		}
		if(i!=n&&isOpen(i+1,j)){
			grid.union(xyTo1d(i, j), xyTo1d(i+1, j));
			gridWith0.union(xyTo1d(i, j), xyTo1d(i+1, j));
		}
		if(isBottom(i, j))
			grid.union(xyTo1d(i, j), n*n+1);
		if(isTop(i, j)){
			grid.union(xyTo1d(i, j), 0);
			gridWith0.union(xyTo1d(i, j), 0);
		}
	}

	public boolean isOpen(int i, int j) {
		int index=xyTo1d(i, j);
		return stat[index];
	}

	public boolean isFull(int i, int j) {
		int index=xyTo1d(i, j);
		if(grid.connected(index, 0)&&gridWith0.connected(index, 0)){
				return true;
		}
		return false;
	}

	public boolean percolates() {
		return grid.connected(0, n*n+1);
	}
	
	public static void main(String[] args) {
		Percolation p=new Percolation(3);
		p.open(1, 2);
		p.open(2, 2);
		p.open(2, 3);
		p.open(3, 3);
		System.out.println(p.isFull(1, 1));	
	}
}