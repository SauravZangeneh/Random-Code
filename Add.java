import java.util.*;
import java.lang.*;
public class Add{
	int i;
	int j;
	int store;
	int carry=0;
	char[] digits;
	char[] digits2;
	public static ArrayList<Character> storeArray = new ArrayList<Character>();
	

	public void addmethod(int i,int j){    
		String random = String.valueOf(i); 
		char[] dummy = random.toCharArray();  //converts integer to array of characters

		String random2 = String.valueOf(j);   // the if statements are used to convert unequal lengths of integers to the same length by adding 0s before the integer
		char[] dummy2 = random2.toCharArray();

		if (dummy2.length >= dummy.length){
			char[] chars = new char[dummy2.length-dummy.length];
			Arrays.fill(chars, '0');
			String s = new String(chars);

			String boop = s + String.valueOf(i); 
			System.out.println(boop);
			digits = boop.toCharArray();
			digits2=dummy2;
		}

		else if (dummy.length >= dummy2.length){
			char[] chars = new char[dummy.length-dummy2.length];
			Arrays.fill(chars, '0');
			String s = new String(chars);

			String boop2 = s + String.valueOf(j); 
			digits2 = boop2.toCharArray();
			digits = dummy;

		}

		else if (dummy.length == dummy2.length){
			digits=dummy;
			digits2=dummy2;
		}

	
		for(int m=digits.length ; m>0 ; m--){

			store = Character.getNumericValue(digits[m-1]) + Character.getNumericValue(digits2[m-1]) + carry; // converts characters to digits and adds them
			carry = 0;
		
			if (store>9){   // this statement allows you to 'carry the one'.
				store = store%10;
				carry = 1;
			}
			storeArray.add (digits.length - m, Character.forDigit(store,10));

			if (m == 1 && carry==1){
				storeArray.add(digits.length, '1');
			}
		}
		Collections.reverse(storeArray);
		System.out.println(storeArray);

	}

	public static void main(String[] args){
		Add addobject = new Add();
		addobject.addmethod(1234,999);  //testing
	}
}
