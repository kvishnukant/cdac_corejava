package generics;

public class ArrayUtils1 {
	//below is not a generic method
	public static Pair<String> minMax(String[] arr)
	{
		if (arr == null || arr.length ==0)
			return null;
		
		String min=arr[0];
		String max=arr[0];
		for (int i=1;i<arr.length;i++)
		{
			if (min .compareTo(arr[i]) > 0)  min=arr[i];
			if (max .compareTo(arr[i]) < 0)  max=arr[i];
		}
		return new Pair<String>(min,max);
	}
	//generic method example -- where method param is typed 
	public static  <T> T getMedian(T[] arr)
	{
		
		return arr[arr.length/2];
		
	}
}
