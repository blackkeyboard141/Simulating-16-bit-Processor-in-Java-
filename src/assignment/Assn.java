package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		FileReader fr;
		String str;
		String intro;
		int intr=0;
		HashMap<Integer,String> hm = new HashMap<Integer, String>();	//main program
		
		HashMap<Integer,String> ast = new HashMap<Integer, String>();   //address symbol table
		
		try {
			fr = new FileReader("INPUT.txt");
			BufferedReader br = new BufferedReader(fr);
			
			
			
			
			
			
			
			/*while((str=br.readLine())!=null){
				
				System.out.println(str);
				}*/
			str= br.readLine();
			//System.out.println(str);
			//System.out.println(str.length());
			intro=str.substring(4,str.length());
			intr=Integer.parseInt(intro);
			
			
			while((str=br.readLine())!=null){
				
				hm.put(intr, str);
				intr++;
				
				
				
			}
			
			
			
			
			br.close();
			
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}
		
		for( Map.Entry<Integer, String> entry: hm.entrySet()){
			
			int key = entry.getKey();
			String value = entry.getValue();
			
			if(value.indexOf(",")>=0){
				ast.put(key, value.substring(0, 4));
				
			}
			
		}
		
		
			for( Map.Entry<Integer, String> entry: ast.entrySet()){
			
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.printf("%s ",value.substring(0,2));
			System.out.print(Integer.toBinaryString((int)value.charAt(0)));
			System.out.println(" "+Integer.toBinaryString((int)value.charAt(1)));
			
			
			System.out.printf("%s ",value.substring(2,4));
			System.out.print(Integer.toBinaryString((int)value.charAt(2)));
			System.out.println(" "+Integer.toBinaryString((int)value.charAt(3)));
			
			System.out.print("(LC) "+Integer.toBinaryString(Integer.parseInt(Integer.toString(key).substring(0,1))));
			System.out.println(" "+Integer.toBinaryString(Integer.parseInt(Integer.toString(key).substring(1,3))));
			
			//System.out.println(Integer.toBinaryString(1));
			
			//System.out.println("(LC) "+ Integer.toBinaryString((int)Integer.toString(key).charAt(0)));
			
		}  //first pass
			
			
			
		
	


	
	
	}}
