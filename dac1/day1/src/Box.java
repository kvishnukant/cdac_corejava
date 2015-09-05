//default or public --- cls level 
//member --- private ,default,protected or public
class  Box
{
   //D.M
   private double width,depth,height;
   Box(double w,double d,double height)
	{
//	   System.out.println("width="+width);
	   width=w;
	   depth=d;
	   this.height=height;
	}
	//B.L 
	void displayDims()
	{
		System.out.println("Box dims are "+width+"  "+depth+"  "+height);
	}
	double calcVolume()
	{
		return width*depth*height;
	}
}
