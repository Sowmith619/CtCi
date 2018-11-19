package moderate;

import java.util.LinkedList;
import java.util.List;

public class englishInt {
	static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
						"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String[] bigs = {"", "Thousand", "Million", "Billion"};
	static String hundred = "Hundred";
	static String negative = "Negative";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2078500;
		System.out.println(n+":"+convert(n));
	}
	public static String convert(int num) {
		if(num==0) return smalls[0];
		if(num<0) return negative + " " + convert(-num);
		LinkedList<String> parts = new LinkedList<>();
		int countChuck=0;
		while(num>0) {
			if(num%1000!=0) {
				String chuck = convertChuck(num%1000)+" "+bigs[countChuck];
				parts.addFirst(chuck);
			}
			countChuck++;
			num=num/1000;
		}
		return listtoString(parts);
	}
	public static String convertChuck(int num) {
		LinkedList<String> parts = new LinkedList<>();
		//hundred
		if(num>=100) {
			parts.addLast(smalls[num/100]);
			parts.addLast(hundred);
			num=num%100;
		}
		//tens
		if(num>=10 && num<=19) {
			parts.addLast(smalls[num]);
		}else if(num>=20) {
			parts.addLast(tens[num/10]);
			num=num%10;
		}
		//one
		if(num>=1 && num<=9)
			parts.add(smalls[num]);
		
		return listtoString(parts);
	}
	public static String listtoString(LinkedList<String> parts) {
		StringBuilder sb = new StringBuilder();
		while(parts.size()>1) {
			sb.append(parts.pop()).append(" ");
		}
		sb.append(parts.pop());
		return sb.toString();
	}

}
