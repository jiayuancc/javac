package com.knightsight.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private int n;
	private int trials;
	private double []m;
	public PercolationStats(int n, int trials){
		if(n<=0||trials<=0)
			throw new IllegalArgumentException("Illegal");
		this.n=n;
		this.trials=trials;
		m=new double[trials];
		for(int i=0;i<trials;i++){
			Percolation p=new Percolation(n);
			int count=0;
			while(!p.percolates()){
				int row=StdRandom.uniform(n)+1;
				int column=StdRandom.uniform(n)+1;
				if(!p.isOpen(row, column)){
					count++;
					p.open(row,column);
				}
			}
			m[i]=(double)count/(n*n);
			//System.out.println(count+" "+n*n);
		}
		
	}    // perform trials independent experiments on an n-by-n grid
	public double mean() { // sample mean of percolation threshold
		return StdStats.mean(m);
	}
	public double stddev(){  // sample standard deviation of percolation threshold
		 return StdStats.stddev(m);
	}                      
	public double confidenceLo(){  // low  endpoint of 95% confidence interval
		double t=Math.pow(trials, 0.5);
		return mean()-(1.96*stddev()/t);
	}               
	public double confidenceHi(){
		double t=Math.pow(trials, 0.5);
		return mean()+(1.96*stddev()/t);
	}                 // high endpoint of 95% confidence interval

	public static void main(String[] args){
		PercolationStats p=new PercolationStats(200, 100);
		System.out.println(p.mean()+" "+p.confidenceHi());
			   
	 }    // test client (described below)
	
}
