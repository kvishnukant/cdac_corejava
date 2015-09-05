package safe_colls;

import java.util.*;

public class NameList {
	/*private List<String> names = Collections
			.synchronizedList(new LinkedList<String>());
*/
	 List<String> names =new LinkedList<>();
	
	
	public void add(String name) {
		names.add(name);
	}

	public String removeFirst() {
		if (names.size() > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			return names.remove(0);
		} else
			return null;
	}
}