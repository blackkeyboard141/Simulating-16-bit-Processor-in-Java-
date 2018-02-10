package assignment;

import java.util.HashMap;
import java.util.Map;

public class Hashtry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashMap<Integer,String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		
	//	System.out.println(hm.size());
		
		for( Map.Entry<Integer, String> entry: hm.entrySet()){
			
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+":"+value);
			
			
			
		}

	}

}
