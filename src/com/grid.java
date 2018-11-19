package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class grid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] {{0,1,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
		
		//Display the initial grid
		System.out.println("GRID::");
		for(int r=0;r<grid.length;r++) {
			for(int c=0;c<grid[0].length;c++)
				System.out.print(grid[r][c]+" ");
			System.out.println();
			}System.out.println();
		//Compute size of each island
		computeSize(grid);
		//count the number of island
		countIsland(grid);
	}
	//Compute Size
	public static void computeSize(int[][] grid) {
		int sum=0;
		List<Integer> gridSize = new LinkedList<>();
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++)
				if(grid[i][j]==0) {
					sum=computeSize(grid, i, j);
					gridSize.add(sum);
				}
		System.out.print("\nSize of Islands:: ");
		for(int n:gridSize)
			System.out.print(n+" ");
	}
	public static int computeSize(int[][] grid, int r, int c) {
		if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!=0)
			return 0;
		int sum=1;
		grid[r][c]=-1;
		for(int dx=-1;dx<=1;dx++)
			for(int dy=-1;dy<=1;dy++)
				if(dx==0 || dy==0)
					sum+=computeSize(grid,r+dx, c+dy);
		return sum;
	}
	//Count the number of islands: 1 = island
	public static void countIsland(int[][] grid) {
		int count=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					mark(grid, i, j);
					count++;
				}
			}
		}
		System.out.println("\nNum of Islands:: "+count);
	}
	public static void mark(int[][] grid, int r, int c) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1)
			return;
		grid[r][c]=0;
		for(int dx = -1;dx<=1;dx++)
			for(int dy=-1;dy<=1;dy++)
				if(dx==0||dy==0)
					mark(grid, r+dx, c+dy);
	}
}
