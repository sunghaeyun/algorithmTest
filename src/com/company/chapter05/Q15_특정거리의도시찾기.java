package com.company.chapter05;

import java.util.Arrays;

public class Q15_특정거리의도시찾기 {
	//����3
	static int N = 4;
	static int M = 4;
	static int K = 1;
	static int X = 1;
	static int inf = Integer.MAX_VALUE;
	static int[][] dArr = {{0,1,1,inf},{inf, 0, 1,1},{inf,inf, 0, inf},{inf,inf,inf,0}};
//	//����2
//	static int N = 4;
//	static int M = 3;
//	static int K = 2;
//	static int X = 1;
//	static int inf = Integer.MAX_VALUE;
//	static int[][] dArr = {{0,1,1,1},{inf, 0, inf,inf},{inf,inf, 0, inf},{inf,inf,inf,0}};
	//����1
//	static int N = 4;
//	static int M = 4;
//	static int K = 2;
//	static int X = 1;
//	static int inf = Integer.MAX_VALUE;
//	static int[][] dArr = {{0,1,1,inf},{inf, 0, 1,1},{inf,inf, 0, inf},{inf,inf,inf,0}};
	static int[] len = new int[K];
	static boolean[] bArr = new boolean[N];
	public static void main(String[] args) {
		
		
		dfs(X-1);
		
		System.out.println(Arrays.toString(bArr));
	}
	
	private static void dfs(int X){
		System.out.println("X : "+X+", len : "+Arrays.stream(len).sum());
		if(Arrays.stream(len).sum()==K){
			bArr[X] = true;
			return;
		}
		
		for(int i=0; i<dArr[X].length; i++){	
			if(dArr[X][i] == 1){
				len[X] = 1;
				System.out.println("X : "+X+", i : "+i+", len : "+Arrays.stream(len).sum());
				dfs(i);
				len[X] = 0;
			}
		}
	}
}
