package com.company.chapter03;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 큰 수의 법칙
 */
public class 큰수의법칙 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scan = new Scanner(System.in);
		
		String nmk = scan.nextLine();
		String numList = scan.nextLine();
		
		int[] nmkIntArr = Arrays.stream(nmk.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		
		int N = nmkIntArr[0]; //2<=N<=1000
		int M = nmkIntArr[1]; //1<=M<=10000
		int K = nmkIntArr[2]; //1<=K<=10000	//K>=M
		
		if(2 > N || N > 1000 ){ System.out.println("error :: N size is invalid"); System.exit(0);}
		if(1 > M || M > 10000 ){ System.out.println("error :: M size is invalid"); System.exit(0);}
		if(1 > K || K > 10000 ){ System.out.println("error :: K size is invalid"); System.exit(0);}
		
		
		int[] numListArr =  Arrays.stream(numList.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		for(int num : numListArr){
			if(1 > num || num > 10000 ){
				System.out.println("error :: num size is invalid ->"+num);
				System.exit(0);
				break;
			}
		}
		
		int cnt  = 0;
		int idx =  0;
		int max = numListArr[numListArr.length-1];
		int scndmax = numListArr[numListArr.length-2];
		
		int sum = 0;
		StringBuffer sb = new StringBuffer(); 
		
		//내가 작성한 소스
		for(idx = 0; idx <M; idx++){
			if(0 <= cnt && cnt < K){
				sum += max;
				sb.append(max);
				cnt++;
			}
			else{
				sum += scndmax;
				cnt = 0;
				sb.append(scndmax);
			}

			if(idx<M-1) sb.append("+");
		}
		sb.append("="+sum);


		//교재에서 작성한 소스
//		while(true){
//			for (idx = 0; idx < K; K++){
//				if(M == 0) break;
//				sum += max;
//				M -= 1;
//			}
//			if(M==0) break;
//			sum += scndmax;
//			M -= 1;
//		}
		
		System.out.println("sum : "+sum);
		System.out.println("수식 : "+sb);
		
	}

}
