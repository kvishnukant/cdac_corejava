package com.app.core;

//default or public --- cls level 
//member --- private ,default,protected or public
public class  Box
{
   //D.M
   private double width,depth,height;
   public Box(double w,double d,double height)
	{
//	   System.out.println("width="+width);
	   width=w;
	   depth=d;
	   this.height=height;
	}
	//B.L 
	public void displayDims()
	{
		System.out.println("Box dims are "+width+"  "+depth+"  "+height);
	}
	public double calcVolume()
	{
		return width*depth*height;
	}
}
