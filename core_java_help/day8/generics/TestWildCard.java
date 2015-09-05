package generics;
import static generics.WildCardUsage.*;

public class TestWildCard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pair<Mgr> p1=new Pair(new Mgr(1,"aa" ,100),new Mgr(2,"bb",200));
		printBuddies(p1);
	}

}
