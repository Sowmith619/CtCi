package moderate;

public class operations {
	//All operation using only add
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3, b=2;
		System.out.println(negate(a));
		System.out.println(minus(a,b));
		System.out.println(multiply(a,b));
		System.out.println(divide(a,b));
	}
	//negate of a number
	public static int negate2(int a) {
		int neg=0;
		int sign=a<0?1:-1;
		while(a!=0) {
			neg+=sign;
			a+=sign;
		}
		return neg;			
	}
	//negate_optimized
	public static int negate(int a) {
		int neg = 0;
		int newSign = a<0? 1:-1;
		int delta = newSign;
		while(a!=0) {
			boolean diff = (a+delta>0) != (a>0);
			if(a+delta !=0 && diff)
				delta = newSign;
			neg+=delta;
			a+=delta;
			delta+=delta;
		}
		return neg;
	}
	//Subtraction
	public static int minus(int a, int b) {
		return a+negate(b);
	}
	//Multiply
	public static int multiply(int a, int b) {
		if(a<b)
			return multiply(b,a);
		int sum=0;
		for(int i=abs(b); i>0; i=minus(i,1))
			sum+=a;
		if(b<0)
			sum=negate(sum);
		return sum;		
	}
	public static int abs(int a) {
		if(a<0)
			return negate(a);
		else
			return a;
	}
	//divide a number
	public static int divide(int a, int b) {
		int abs_a=abs(a);
		int abs_b=abs(b);
		int product=0;
		int x=0;
		while(product+abs_b<=abs_a) {
			product+=abs_b;
			x++;
		}
		if((a<0 && b<0)||(a>0 && b>0))
			return x;
		else
			return negate(x);
	}

}
