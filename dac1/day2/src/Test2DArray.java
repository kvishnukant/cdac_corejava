import java.util.Arrays;
class Test2DArray 
{
	public static void main(String[] args) 
	{
		//symmetric or rectangular array
		double[][] data=new double[3][4];
		for (int i=0;i<data.length;i++)
		{
			for (int j=0;j<data[i].length ;j++ )
			{
				System.out.print(data[i][j]+" ");
			}
		}
		System.out.println();
		int counter=1;
		for (int i=0;i<data.length;i++)
		{
			for (int j=0;j<data[i].length ;j++ )
			{
				data[i][j]=counter++;
			}
		}
		System.out.println("o/p via ToString");
		//how to display array elems --- easily from API 
		//returns string representation of array 
		System.out.println(Arrays.toString(data));
		System.out.println("o/p via deepToString");
		System.out.println(Arrays.deepToString(data));
		System.out.println("o/p via for-each");
	    //via for each
		for (double[] d : data )
		   for (double d1 : d )
		  System.out.print(d1+" ");
	
	}
}
