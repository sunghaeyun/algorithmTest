package com.company.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class Q05_볼링공고르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String numStr = scan.nextLine();
		int[] numIntArr = Arrays.stream(numStr.split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = numIntArr[0];
		int m = numIntArr[1];

		String weiStr = scan.nextLine();
		int[] weiArray = Arrays.stream(weiStr.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		for(int a:weiArray){
			if(a>m){
				System.out.println("무게가 잘못입력되었습니다.");
				System.exit(0);
			}
		}


		// 소팅하고. 순차적으로 더함 n-(index+1)만큼. weiArray[index]값이 이전 수와 같으면 하나씩 뺌.
		// 그리고 n-(index+1)이 0이하가 되면 끝.
		int index = 0;
		int pre = 0;
		int sum = 0;
		while(index<weiArray.length){
			if(pre == weiArray[index]) sum -= 1;
			if(n - index + 1 <= 0) break;
			sum += n - (index+1);
			pre = weiArray[index];
			index++;
		}
		
		
		System.out.println(sum);
	}

}
