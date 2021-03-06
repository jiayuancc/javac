package com.knight.test;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class GameFrame extends MyFrame {
	
	
   Image img=GameUtil.getImage("images/universe.jpg");
   Image dot=GameUtil.getImage("images/dot.png");
 
   private double x,y;
   private double degree=0.5;//[0,2pi];
   boolean reverse;
   private double speed=1;
   @Override
   
   public void paint(Graphics g) {
	    	
	        
	    	
	     	Font f=new Font("song",Font.BOLD,20); 	
	     	g.setColor(Color.BLUE);
	     	g.setFont(f);
	     	
	    	
	    	g.drawString("这是一个游戏", 150, 50);
	    	//g.drawImage(img,0,0,null);
	    	g.drawImage(dot,(int)x,(int)y,null);
	    	/*
	    	if(x==480)reverse=true;
	        if(x==0)reverse=false;
	        if(reverse=true)x=x-3;
	        else x=x+3;
	        */
	    	if(speed>0)speed+=0.1;
	    	x+=speed*Math.cos(degree);
	    	y+=speed*Math.sin(degree);
	    	
	    	if(x>480||x<0)degree=Math.PI-degree;
	    	if(y>480||y<0)degree=-degree;
	    	
	    	
	    	 
	    			
	}	
   
  
 
   public static void main(String[] args) {
		GameFrame g=new GameFrame();
		g.launchFrame(); 
	}
	

}
