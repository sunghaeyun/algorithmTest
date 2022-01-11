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

		int idx = 0;
		int sum = 1;
		while(idx < coinArray.length){
			if(sum < coinArray[idx]) break;
			sum += coinArray[idx];
			idx++;
		}
		
		System.out.println(sum);
	}

}
