package dynamic_recur;

public class coinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coinChange();
		coinChange2();
	}
	//given coins of different denominations & amount 
	//Write a func to compute the fewest number of coins needed for amount.
	public static void coinChange() {
		int[] coins = new int[] {1,2,3};
		int amount=10;
		
		int[] dp = new int[amount+1];
		for(int sum=1;sum<=amount;sum++) {
			int min=-1;
			for(int coin:coins) {
				if(sum>=coin && dp[sum-coin]!=-1) {
					int temp = dp[sum-coin]+1;
					min = min<0? temp:temp<min?temp:min;
				}
			}
			dp[sum]=min;
		}
		System.out.println("coinChange:"+dp[amount]);
	}
	public static void coinChange2() {
		int[] coins = new int[] {1,2,3};
		int amount=3;
		
		int[] dp = new int[amount+1];
		dp[0]=1;
		for(int coin:coins) {
			for(int sum=coin;sum<=amount;sum++) {
				dp[sum]+=dp[sum-coin];
			}
		}
		System.out.println("coinChange2:"+dp[amount]);
	}
}
