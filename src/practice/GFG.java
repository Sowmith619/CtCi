package practice;

import java.util.HashMap;
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		//code
		int res=-1;
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		System.out.println("Number of Input:"+n);
		while(n>0){
		    n--;
		    /*String in = s.nextLine();
		    in = in.trim();
		    String[] input = in.split(" ");
		    int start = Integer.parseInt(input[0]);
		    int end = Integer.parseInt(input[1]);*/
		    int start = s.nextInt();
		    int end = s.nextInt();
		    System.out.println("Start:"+start+" end:"+end);
		    HashMap<Integer, Integer> map = new HashMap<>();
		    for(int i=start;i<end;i++){
		        if(isPrime(i)){
		        	System.out.println("prime:"+i);
		            int num=i;
		            while(num>0){
		                if(!map.containsKey(num%10))
		                    map.put(num%10,1);
		                else
		                    map.put(num%10, map.get(num%10)+1);
		                num=num/10;
		            }
		        }
		    }
		    int max=0;
		    res=0;
		    for(HashMap.Entry<Integer, Integer> m: map.entrySet() ){
		        int nm = m.getKey();
		        int c = m.getValue();
		        System.out.println("nm:"+nm+" c:"+c);
		        if(max<c){
		            max=c;
		            res=nm;
		        }
		    }
		    System.out.println("Res:"+res);
		}
		s.close();
	}
	public static boolean isPrime(int num){
	    if(num<2) return false;
	    if(num==2) return true;
	    if(num%2==0) return false;
	    for(int i=3;i<num/2;i+=2)
	        if(num%i==0)
	            return false;
	   return true;
	}
}