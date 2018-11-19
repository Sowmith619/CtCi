package com;

public class gridPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uniquePath(5,5);
		uniquePath2(5,5);

		System.out.println("uniquePath3(5,5):"+uniquePath4(4,4, new int[5][5], 5));
	}
	//Runtime O(n^2) || space O(n^2)   start (0,0) = 1
	public static void uniquePath(int n, int m) {
		int[][] grid = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i>=j) {
					if(i==0 || j==0)
						grid[i][j]=1;
					else
						grid[i][j]=grid[i-1][j]+grid[i][j-1];
				}
			}
		}
		System.out.println("Size:"+grid[n-1][m-1]);
	} 
	/* destination (n,n)=1
	public static void uniquePath(int n, int m) {
		int[][] grid = new int[n][m];
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(i>=j) {
					if(i==n-1||j==n-1)
						grid[i][j]=1;
					else
						grid[i][j]=grid[i+1][j]+grid[i][j+1];
				}
			}
		}
		System.out.println("Size:"+grid[0][0]);
	}*/
	//Runtime O(n^2) || space O(n)
	public static void uniquePath2(int n, int m) {
		int[] curr_row=new int[m];
		int[] last_row=new int[m];
		
		for(int i=0;i<m;i++)
			last_row[i]=1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i>=j) {
					if(i==0||j==0)
						curr_row[j]=last_row[j];
					else
						curr_row[j]=curr_row[j-1]+last_row[j];
				}
			}
			for(int j=0;j<m;j++)
				last_row[j]=curr_row[j];
		}
		System.out.println("Size:"+curr_row[n-1]);
		
	}
	//recursion:Runtime O(n^2) || space O(n^2)      uniquePath3(0,0, new int[5][5], 5)
	//destination(n,n)==1
	public  static int uniquePath3(int i, int j, int[][] memo, int n){
		if(i>=n || j>=n || j>i || i<0 || j<0) return 0;
		if(i==n-1 && j==n-1) return 1;
		if(memo[i][j]==0) {
			memo[i][j]=uniquePath3(i+1,j, memo, n) + uniquePath3(i, j+1, memo, n);
		}
		return memo[i][j];
		
	}
	//start(0,0)==1
	public  static int uniquePath4(int i, int j, int[][] memo, int n){
		if(i>=n || j>=n || i<0 || j<0 || j>i) return 0;
		if(i==0 && j==0) return 1;
		if(memo[i][j]==0)
			memo[i][j]=uniquePath4(i-1,j, memo, n)+uniquePath4(i,j-1,memo, n);
		return memo[i][j];
	}
}
