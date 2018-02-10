package testing;

public class testing {
	

	public static void main(String[] args) {
		
		String number ="111";
		int required_digits = 4;
		System.out.println(digit_filler(number,required_digits));
		// TODO Auto-generated method stub

	}
	
static String digit_filler(String num, int digits) {
	
	    StringBuffer s = new StringBuffer(digits);
	    
	    for (int i = 0; i < (digits - num.length()); i++) {
	    	
	        s.append(0);
	    }
	    
	    return s.append(num).toString();
	}

}