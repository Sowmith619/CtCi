package practice;

public class fizzbuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzbuzz();
	}
	//Write a program that prints the numbers from 1 to 100. 
	//But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
	//For numbers which are multiples of both three and five print “FizzBuzz”.
	public static void fizzbuzz() {
		String fizz="fizz",buzz="buzz";
		for(int i=1;i<=100;i++) {
			if(i%15==0)
				System.out.println(fizz+buzz);
			else if(i%3==0)
				System.out.println(fizz);
			else if(i%5==0)
				System.out.println(buzz);
			else
				System.out.println(i);
		}
		for(int i=1;i<=100;i++) {
			String test="";
			test += (i%3)==0?"fizz":"";
			test += (i%5)==0?"buzz":"";
			System.out.println(test.isEmpty()?i:test);
		}
	}

}
