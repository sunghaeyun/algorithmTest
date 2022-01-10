package com.company.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Q04_만들수없는금액 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String nt = scan.nextLine();
		int n = Integer.parseInt(nt);
		String tempStr = scan.nextLine();
		int[] coinArray = Arrays.stream(tempStr.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		
		
//		int idx = 0;
//		int preNum = 0;
//		int result = 0;
//		int gap = 0;
//		while(true){
//			if(idx >= coinArray.length) break;
//			System.out.println("coinArray[idx]:"+coinArray[idx]);
//			System.out.println("preNum:"+preNum);
//			gap = coinArray[idx] - preNum;
//			if(gap >= 2){
//				int subIdx = 0;
//				int subSum = 0;
//				boolean find = false;
//				while(subIdx < idx){
//					subSum += coinArray[subIdx];
//					System.out.println("subSum:"+subSum);
//					if(gap == subSum){
//						find = true;
//						result = coinArray[subIdx]-1;
//						break;
//					}
//					subIdx++;
//				}
//				if(!find)	break;
//			}
//			preNum = coinArray[idx];
//			idx++;
//		}
		
		int result = 0;
		int index = 1;
		while (true) {
			
			int subIndex = 0;
			int subSum = 0;
			boolean flag = false;
			System.out.println("index:"+index);
			while(subIndex<coinArray.length){
				System.out.println("subIndex:"+subIndex);
				subSum += coinArray[0];
				System.out.println("subSum:"+subSum);
				if(index < subSum) break;
				if(index == subSum){
					flag = true;
					break;
				}
				subIndex++;
			}
			if(!flag){
				result = index;
				break;
			}
			index++;
		}
		
		
		System.out.println(result);
	}

}
