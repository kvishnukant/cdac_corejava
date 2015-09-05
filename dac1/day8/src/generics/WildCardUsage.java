package generics;

public class WildCardUsage {
//	public static <T extends Emp> void printBuddies(Pair<T> p)
	public static  void printBuddies(Pair<? extends Emp> p)
	// below stmt causes err , while using Pair<Mgr> as method arg since  Pair<Emp> is NOT super-class of Pair<Mgr>
	//public static void printBuddies(Pair<Emp> p)
	{
		System.out.println(p.getFirst().getName() +" and "+p.getSecond().getName() +" are buddies");
	}

}
