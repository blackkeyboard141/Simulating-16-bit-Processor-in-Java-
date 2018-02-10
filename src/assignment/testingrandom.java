package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class testingrandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(Integer.toBinaryString(107));
		
		try {
			FileReader mr;
			String mrt;
			
			mr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(mr);
			
		
			mrt= br.readLine();
			
			System.out.println(mrt.length());
			
			System.out.println(mrt.substring(8, mrt.length()));
			
			
			
			
			/*while((mrt=br.readLine())!=null){
				
				if(mrt.substring(0,3).contains("CMA")){
				System.out.println(mrt.substring(0, 3));}
			
				 /*if(mrt.substring(0, 2)==value){
					output.put(intr, mrt.substring(4, mrt.length())) ;
					intr++;
					break;
				 }
				*/
			
			
			
			
			
			br.close();
			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
		}

	}

}
