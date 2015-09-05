import java.util.Arrays;

class TestPrimArrays 
{
	public static void main(String[] args) 
	{
		final double[] data;//array type of ref
		//OR int data[] 
		//System.out.println("Hello World!");
		data=new double[10];
		for (int i=0;i<data.length ;i++)
		{
			System.out.printf("%.1f ",data[i]);
			data[i]=i*2;
		}
		//print array again --- using toString
		System.out.println(Arrays.toString(data));
		//for-each syntax
		//1st iteration -- implicit assgn --- d=data[0],d=data[1]
		//last assign d=data[data.length-1];
		for(double d : data)	   {
			d *= 2;
			System.out.printf("%.1f ",d);
		}
			System.out.println("o/p again" +Arrays.toString(data));
			data=new double[20];
			System.out.println(Arrays.toString(data));
	}

}
