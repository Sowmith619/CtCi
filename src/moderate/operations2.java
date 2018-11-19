package moderate;

public class operations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(negate(5));
		System.out.println(subtract(5,3));
		System.out.println(multiply(5,2));
		System.out.println(divide(12,2));
	}
	public static int negate(int a) {
		int neg = 0;
		int sign = a<0?1:-1;
		while(a!=0) {
			neg+=sign;
			a+=sign;
		}
		return neg;
	}
	public static int negate2(int a) {
		int neg = 0;
		int newSign = a<0?1:-1;
		int delta = newSign;
		while(a!=0) {
			boolean diffSign = (a+delta>0) != (a>0);
			if(a+delta !=0 && diffSign)
				delta = newSign;			
			neg+=delta;
			a+=delta;
			delta+=delta;
		}
		return neg;
	}
	public static int subtract(int a, int b) {
		int neg_b = negate2(b);
		return a+neg_b;
	}
	public static int multiply(int a, int b) {
		if(a<b)
			return multiply(b,a);
		int sum=0;
		for(int i=abs(b);i>0;i=subtract(i,1))
			sum+=a;
		if(b<0)
			sum=negate(sum);
		return sum;
	}
	public static int abs(int a) {
		if(a<0)
			return negate(a);
		return a;
	}
	public static int divide(int a, int b) {
		int abs_a = abs(a);
		int abs_b = abs(b);
		int product=0, x=0;
		while(product+abs_b<=abs_a) {
			product+=abs_b;
			x++;
		}
		if((a>0 && b>0)||(a<0 && b<0))
			return x;
		else
			return negate(x);
	}

}
