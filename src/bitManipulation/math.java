package bitManipulation;

import java.util.Arrays;

public class math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prime();
		printAllPrimes();
		countPrime();
	}
	public static void prime() {
		int n=201;
		if(n<2) {
			System.out.println("Not Prime:"+n);
			return;
		}
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				System.out.println("Not Prime::"+n);
				return;
			}
		}
		System.out.println("Is prime");
	}
	public static void printAllPrimes() {
		int n=10;
		int num=2;
		int count=0;
		while(count<n) {
			if(isPrime(num)) {
				count++;
				System.out.print(num+"-");
			}
			num++;
		}
	}
	public static boolean isPrime(int num) {
		if(num<2) return false;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
	//count the number of primes less than n
	public static void countPrime() {
		int n=3;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		int count=0;
		if(n<2) {
			System.out.println("No prime number less than 2");
			return;
		}
		for(int i=2;i<n;i++) {
			if(primes[i]==true) {
				count++;
				for(int j=2;j*i<n;j++)
					primes[j]=false;
			}
		}
		System.out.println("countPrimes:"+count);
	}
	

}
