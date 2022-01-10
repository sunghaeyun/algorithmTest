package com.company.chapter03;

import java.util.Scanner;

public class Q02_곱하기혹은더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		// 띄어쓰기로 받는줄
		//String str = scan.nextLine();
		//int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

		// int는 자릿수 최대 10자리까지 받는데 문제조건이 20이하이기 때문에 사용할 수 없음.
		// String으로 처리
		String tot = scan.nextLine();
		int[] numArr = new int[tot.length()];
		int idx = 0;
		while(idx < tot.length())	numArr[idx] = Integer.parseInt(tot.substring(idx, ++idx));


		// 왼쪽부터 오른쪽으로 하나씩 숫자를 하면서 연산해주는 것이기때문에 순서대로 연산 후 sum에 넣는다.
		// 최대값을 위해서는 곱하기가 제일 바람직하나, 0을 곱하면 0이 되버리기때문에 0일 경우만 체크해준다.
		// (1)sum이 0일 경우 (2)연산할 숫자가 0일 경우를 확인하여 처리해준다.
		int sum = numArr[0];
		idx = 1;
		while(idx < numArr.length){
			if(sum == 0 || numArr[idx] == 0) sum += numArr[idx++];
			else							 sum *= numArr[idx++];
		}
		
		System.out.println(sum);

	}

}
