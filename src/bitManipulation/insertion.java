package bitManipulation;

public class insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trick();
		insertion();
		flipToWin();
		conversion();
		pairwiseSwap();
	}
	public static void trick() {
		int N = 0b11001111;
		int i=6;
		System.out.println("BitManipulation N:"+Integer.toBinaryString(N)+" i:"+6);
		//get ith bit
		int result= (N&(1<<i))!=0? 1:0;
		System.out.println("get ith bit res:"+result);
		//set ith bit
		result = (N|(1<<i));
		System.out.println("set ith bit res:"+Integer.toBinaryString(result));
		//clear ith bit
		int mask = 1<<i;
		result=N^mask;
		System.out.println("clear ith bit res:"+Integer.toBinaryString(N));
		//clear MSB to i
		mask = (1<<i)-1; //0001111
		result=N&mask;
		System.out.println("clear MSB to i:"+Integer.toBinaryString(result));
		//clear i to 0
		mask= (-1<<i);
		result = N&mask;
		System.out.println("clear i to 0:"+Integer.toBinaryString(result));
		//update i to val;
		int val=0;
		result=N&~(1<<i) | (val<<i);
		System.out.println("update i to val:"+Integer.toBinaryString(result));
		
		System.out.println(0b101);
	}
	public static void insertion() {
		int n = 0b1000000000, m = 0b10011, i=2, j=6;
		int allOnes = ~0;
		int left = allOnes<<j+1;
		int right = (1<<i)-1;
		int mask = left|right;
		int n_cleared = n&mask;
		int m_shifted = m<<i;
		int res = n_cleared | m_shifted;
		System.out.println(Integer.toBinaryString(res));
	}
	//5.3 find length of the longest sequence of 1s created by fliping one bit from 0 to 1
	public static void flipToWin() {
		int a = 0b110101;
		if(~a==0) {
			System.out.println("flipToWin:"+Integer.BYTES*8);
			return;
		}
		int currLen=1;
		int prevLen=1;
		int maxLen=0;
		while(a!=0) {
			if((a&1)==1) {
				currLen++;
			}else if((a&1)==0) {
				prevLen = (a&2)==0?0:currLen;
				currLen=0;
			}
			a=a>>>1;
			maxLen=Math.max(maxLen, prevLen+currLen+1);
		}
		System.out.println("flipToWin maxLen:"+maxLen);
	}
	//5.4 Given an int, find the next smallest & largest that has exact same number of 1s
	public static void nextNumber() {
		
	}
	//5.6 Determine the number of bits you would need to flip to convert integer A --> B
	//(n&(n-1)) == 0; checks if n is a power of 2 (or if n is 0).
	public static void conversion() {
		int a=0b11101, b=0b01111;
		int count=0;
		for(int c=a^b;c!=0;c=c>>1)
			count+=c&1;
		System.out.println("count:"+count);
		
		//optimal
		count=0;
		for(int c=a^b;c!=0;c=c&(c-1))
			count++;
		System.out.println("optimized count:"+count);
	}
	//5.7 Swap odd and even digit in a integer
	public static void pairwiseSwap() {
		int num = 0b1010110;
		int res = (num & 0xaaaaaaaa)>>>1 | (num & 0x55555555)<<1;
		System.out.println("pairwiseSwap res:"+Integer.toBinaryString(res));
		
		int n=0b101;
		//(n&(n-1))==0 implies that n is a power of 2
		System.out.println("n:"+Integer.toBinaryString(n)+" n-1:"+Integer.toBinaryString(n-1)+" n&(n-1)==0:"+ ((n&(n-1)) == 0));
	}

}
