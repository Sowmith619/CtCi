package bitManipulation;

public class count2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count();
		
	}
	public static void count() {
		int n= 100;
		int count=0;
		for(int i=2;i<=n;i++) {
			count+=numberOf2(i);
			System.out.print("\ni::"+i+" count::"+count);
		}
		System.out.print("\ncount::"+count);
	}
	public static int numberOf2(int n) {
		int count=0;
		while(n>0) {
			if(n%10==2) {
				count++;
			}
			n/=10;
		}
		return count;
	}

}
