class TestPrimitives 
{
	public static void main(String[] args) 
	{
		int data=123;
		if (data != 0)
		{
			data *= 2;
		}
		System.out.println("data="+data);
		byte b1=0x10;
		byte b2=0x12;
		byte b3=b1+b2;
		b3 += b1;
		System.out.println("res="+b3);
		data='A';
		float f=(float)12.34;
		double d1=12.34f;
	}
}
