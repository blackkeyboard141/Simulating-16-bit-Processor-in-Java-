package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class FpwSp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		HashMap<Integer,String> hm = new HashMap<Integer, String>();	//main program
		
		HashMap<Integer,String> ast = new HashMap<Integer, String>(); //address symbol table
		
		HashMap<Integer,String> output = new HashMap<Integer, String>(); //2nd pass output 
		
		try {
			FileReader fr;
			String str;
			String intro;
			int intr=0;
			fr = new FileReader("INPUT.txt");
			BufferedReader br = new BufferedReader(fr);
			
		
			str= br.readLine();
			
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
			
			if(value.indexOf(",")>=0){								//looking for labels with reference to comma
				ast.put(key, value.substring(0, 4));
				
			}
			
		}
		
		
			for( Map.Entry<Integer, String> entry: ast.entrySet()){
			
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.printf("%s ",value.substring(0,2));
			System.out.printf("%08d ",Integer.parseInt(Integer.toBinaryString((int)value.charAt(0))));
			System.out.printf("%08d\n",Integer.parseInt(Integer.toBinaryString((int)value.charAt(1))));
			
			
			System.out.printf("%s ",value.substring(2,4));
			System.out.printf("%08d ",Integer.parseInt(Integer.toBinaryString((int)value.charAt(2))));
			System.out.printf("%08d\n",Integer.parseInt(Integer.toBinaryString((int)value.charAt(3))));
			
			System.out.printf("(LC) %08d ",Integer.parseInt(Integer.toBinaryString(Integer.parseInt(Integer.toString(key).substring(0,1)))));
			System.out.printf("%08d \n",Integer.parseInt(Integer.toBinaryString(Integer.parseInt(Integer.toString(key).substring(1,3)))));
			
			//System.out.println(Integer.toBinaryString(1));
			
			//System.out.println("(LC) "+ Integer.toBinaryString((int)Integer.toString(key).charAt(0)));
			
		}  //first pass
		
		
		System.out.println();
			
			int intr=0;
			
			for( Map.Entry<Integer, String> entry: hm.entrySet()){
				
				//int key = entry.getKey();
				String value = entry.getValue();
				//System.out.println(value.length());
				
				
				
				
				
				
				//start of mri
				
				if(value.length()==7){
					String	first4 = null ;
					String last12 = null ;
					String finalstr;
					
					try {
						FileReader mr;
						String mrt;
						
						
						mr = new FileReader("MRI.txt");
						BufferedReader br = new BufferedReader(mr);
						
					
						//mrt= br.readLine();
						
						
						
						
						
						
						while((mrt=br.readLine())!=null){
							
							if(value.substring(0,3).contains(mrt.substring(0,3))){
								
							first4= mrt.substring(4,8);
								
							}
							
							
						}//matching with mri table
						
						for( Map.Entry<Integer, String> entry1: ast.entrySet()){
							
							int key1 = entry1.getKey();
							String value1 = entry1.getValue();
							
							
							if(value.substring(3,value.length()).contains(value1.substring(0,3))){
								String keys=Integer.toString(key1);
								/*last12=Integer.toBinaryString(Integer.parseInt(keys.substring(0, 1)))+" "+Integer.toBinaryString(Integer.parseInt(keys.substring(1, 2)))+" "+
										Integer.toBinaryString(Integer.parseInt(keys.substring(2, 3)));*/
								
								last12=digit_filler(Integer.toBinaryString(Integer.parseInt(keys.substring(0, 1))),4)+" "+digit_filler(Integer.toBinaryString(Integer.parseInt(keys.substring(1, 2))),4)+" "+
										digit_filler(Integer.toBinaryString(Integer.parseInt(keys.substring(2, 3))),4);
								
								//System.out.printf("%04d %04d %04d\n",Integer.parseInt(Integer.toBinaryString(Integer.parseInt(keys.substring(0, 1)))),Integer.parseInt(Integer.toBinaryString(Integer.parseInt(keys.substring(1, 2)))),
										//Integer.parseInt(Integer.toBinaryString(Integer.parseInt(keys.substring(2, 3)))));
								
								
							}
							
						
						
						}//matching with address symbol table for binary values
						
						
						
						
						
						
						
						
							
					}//end of try
					
					
					
					catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("error");
					}
					
					finalstr =first4+" "+last12;
					output.put(intr,finalstr);
					intr++;
					
					
					} //end of mri
				
				
				
				
				
				
				
			
				//for non mri
				if(value.length()==3){
					
					//System.out.println(value);
					
					try {
						FileReader mr;
						String mrt;
						
						mr = new FileReader("NMRI.txt");
						BufferedReader br = new BufferedReader(mr);
						
					
						mrt= br.readLine();
						
						
						
						
						while((mrt=br.readLine())!=null){
						
							 if(mrt.substring(0, 3).contains(value)){
								output.put(intr, mrt.substring(4, mrt.length())) ;
								intr++;
								break;
							 }
							
						}
						
						
						
						
						br.close();
						}
					catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("error");
					}	
				
				}//end of nmri
				
				//start of label values
				if(value.length()>=7&&value.contains(",")){
					//for decimal
					if(value.substring(4,7).contains("DEC")){
						String s1=digit_filler(Integer.toBinaryString(Integer.parseInt(value.substring(8,value.length()))),32).substring(16);
						
						output.put(intr,s1);
						intr++;
					}
					
					//for hex
					if(value.substring(4,7).contains("HEX")){
						String s= digit_filler(Integer.toHexString((Integer.parseInt(value.substring(8,value.length())))),16).substring(0,16);
						output.put(intr,s);
						intr++;
					}
				}
			
			
			}
			
			
			for( Map.Entry<Integer, String> entry: output.entrySet()){
				
				//int key = entry.getKey();
				String value = entry.getValue();
				
				System.out.println(value);
			
			
			
			
			}
			}
	
	static String digit_filler(String num, int digits) {
		
	    StringBuffer s = new StringBuffer(digits);
	    
	    for (int i = 0; i < (digits - num.length()); i++) {
	    	
	        s.append(0);
	    }
	    
	    return s.append(num).toString();
	}

}
