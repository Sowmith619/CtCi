package bitManipulation;

public class bit_manipulation {
	//example of inner class
	static class test{
		static String a = "HelloWorld";
		public static void display() {
			System.out.println(a);
		}
		public static void main(String[] args) {
			display();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trick();
		//insertion();
		System.out.println("binary: "+Integer.toBinaryString(-1));
		test t = new test();
		t.display();
		//t.main(args);
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
		System.out.println("binaryToString: "+binaryToString(0.25));
		System.out.println("flipBitToWin: "+flipBitToWin());
	}
	public static void trick() {
		int N = 0b10001111;
		
		//get ith bit
		int i=6;
		System.out.println("BitManipulation Tricks: N:"+Integer.toBinaryString(N)+" i:"+i);
		int result = (N&(1<<i)) != 0 ?1:0;
		System.out.println("get ith bit:"+Integer.toBinaryString(result));
		//set ith bit
		N = N|(1<<i);
		System.out.println("set ith bit:"+Integer.toBinaryString(N));
		//clear bit
		int mask = 1<<i;
		N=N^(mask); 
		System.out.println("clear ith bit:"+Integer.toBinaryString(N));
		//clear MSB to i
		mask = (1<<i)-1;  //0000111111
		N=N&(mask);
		System.out.println("clear MSB to i:"+Integer.toBinaryString(N));
		//clear i to 0
		N = 0b11111111; //N=-1;
		mask =~0<<(i+1);   //11110000   -1<<(i+1)
		N=N&mask;
		System.out.println("clear i to 0:"+Integer.toBinaryString(N));
		//update i to val
		int val =1;
		N=N&~(1<<i) | (val<<i);
		System.out.println("update i:"+Integer.toBinaryString(N)+"\n");
	}
	public static void insertion() {
		int i=2, j=6;
		int N = 0b10000011111;
		int M = 0b1001;
		System.out.println("Insert::"+Integer.toBinaryString(N));
		int mask = (~0<<j+1) | ((1<<i)-1); // ~(~0<<i)
		System.out.println("Insert mask::"+Integer.toBinaryString(mask));
		N=N&mask;
		N=N|(M<<i);
		System.out.println("Insert::"+Integer.toBinaryString(N));
	}
	public static String binaryToString(double num) {
		//Given Num between 0 & 1, that is passed as double, 
		//print the binary representation. eg: 0.72 --> 0.11 (binary)
		//if the num cannot be representated in binary print "ERROR"
		if(num>=1 || num<=0)
			return "error";
		StringBuilder sb = new StringBuilder();
		sb.append('.');
		while(num>0) {
			if(sb.length()>=32)	return "ERROR";
			double r = num*2;
			if(r>=1) {
				sb.append(1);
				num=r-1;
			}else {
				sb.append(0);
				num=r;
			}
		}
		return sb.toString();
	}
	public static int flipBitToWin() {
		int a = 0b10001011;
		if(~a==0) return Integer.BYTES*8;
		
		int currLen=0, prevLen=0;
		int maxLen=1;
		while(a!=0) {
			if((a&1)==1)
				currLen++;
			else if((a&1)==0) {
				prevLen = (a&2)==0?0:currLen;
				currLen=0;
			}
			maxLen = Math.max(prevLen+currLen+1, maxLen);
			a >>>= 1;
		}
		return maxLen;
	}
}
