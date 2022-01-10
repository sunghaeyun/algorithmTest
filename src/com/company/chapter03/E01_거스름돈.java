package com.company.chapter03;

import java.util.HashMap;
import java.util.Map;

/***
 * 거스름돈
 */
public class E01_거스름돈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int n = 1260;
		int cnt = 0;
		int[] coins = {500,100,50,10};
		Map coinCnt =  new HashMap<>();
		for(int coin : coins){
			coinCnt.put(coin, n/coin);
			cnt += n/coin;
			n = n%coin;
		}
		
		System.out.println(coinCnt);
		
	}

}
