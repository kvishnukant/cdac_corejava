package generics;

public class ArrayUtils2 {
	public static <T > Pair<T> minMax(T[] arr)
	{
		if (arr == null || arr.length ==0)
			return null;
		
		T min=arr[0];
		T max=arr[0];
		for (int i=1;i<arr.length;i++)
		{
			if (min.compareTo(arr[i]) > 0)  min=arr[i];
			if (max.compareTo(arr[i]) < 0)  max=arr[i];
		}
		return new Pair<T>(min,max);
	}
}
