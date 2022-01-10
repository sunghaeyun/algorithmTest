package com.company.chapter03;

import java.util.ArrayList;
import java.util.Scanner;

public class Q03_문자열뒤집기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		// int는 자릿수 최대 10자리까지 받는데 문제조건이 100만 미만이기 때문에 사용할 수 없음.
		// String으로 처리
		String tot = scan.nextLine();
		int[] numArr = new int[tot.length()];
		int idx = 0;
		while(idx < tot.length())	numArr[idx] = Integer.parseInt(tot.substring(idx, ++idx));


		// 아이디어는 연속된 숫자의 개수는 의미가 없다는 것에 있음.
		// 먼저 0과 1이 몇번 번갈아 나오는지를 확인.
		// 0101 일 경우 뒤집기를 두번 시도해야, 1111 혹은 0000이 된다.
		// 01010일 경우 뒤집기를 두번 시도해야, 00000이 된다.
		// 즉 0과  1이 번갈아나오는 수열을 구하고 이 수열의 갯수를 2로 나눈 몫이 하나의 문자를 만드는 최소값이 된다.

		// 0과 1이 번갈아 나오는 것이 확인될 때 담는 리스트. 길이를 알 수 없으므로 list사용.
		ArrayList<Integer> resultList = new ArrayList<>();
		//초기값
		resultList.add(numArr[0]);	//첫값은 반복이 필요없으므로 먼저 담는다.
		idx = 1;					// 입력받은 숫자를 탐색할 인덱스
		int listIdx = 0;			// 리스트를 탐색할 인덱스

		//배열의 수만큼 반복문을 돈다.
		while(idx<numArr.length){
			//리스트에 넣은 숫자와 배열의 숫자가 일치하지 않을 경우 리스트를 추가한다.
			if(resultList.get(listIdx) != numArr[idx]){
				resultList.add(numArr[idx]);
				listIdx++;
			}
			idx++;
		}

		// listIdx가 0부터 시작했기때문에 1을 더해준다.
		System.out.println((listIdx+1)/2);
	}

}
