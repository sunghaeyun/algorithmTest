package com.company.chapter05;

import java.util.LinkedList;
import java.util.Queue;


public class EQ02_미로탈출 {
	static int N = 5;
	static int M = 6;
	static int[][] dataArray= {{1,0,1,0,1,0},{1,1,1,1,1,1},{0,0,0,0,0,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};
	static Queue<spot> qu = new LinkedList<>();
	static Queue<Integer> q = new LinkedList<>();
	static int result = 0;
	public static void main(String[] args) {
		System.out.println(bfs());
		
	}
	
	private static int bfs(){
		int[] mx = {-1,1,0,0};
		int[] my = {0,0,-1,1};

		qu.offer(new spot(0,0));
		
		while(!qu.isEmpty()){
			spot f = qu.poll();
			f.printXY(f);
			int temp = dataArray[f.x][f.y];
			System.out.println(temp);
			for(int i = 0; i<4; i++){
				int tx = f.x  + mx[i];
				int ty = f.y  + my[i];
				if(tx <= -1 || tx >= N || ty  <= -1 || ty >= M){
					continue;
				}
				if(dataArray[tx][ty] == 0) continue;
				else if(dataArray[tx][ty] == 1){
					dataArray[tx][ty] = temp + 1; 
					qu.offer(new spot(tx, ty));
				}
			}
		}
		
		return dataArray[N-1][M-1];
	}
	

}
class spot{
	int x;
	int y;
	public spot(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void printXY(spot t){
		System.out.println("x:"+t.x+",y:"+t.y);
	}
}

