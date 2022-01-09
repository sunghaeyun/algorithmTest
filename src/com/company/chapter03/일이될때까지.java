package com.company.chapter03;

import java.util.Scanner;

/*********
 * 연산방식::
 * 1. N에서 1을 뺀다.
 * 2. N을 K로 나눈다.
 *
 * 입력조건::
 * 첫째 줄에 N(2 < N < 100,000)과 K(2 < K < 100,000)가 공백으로 구분되며 각각 자연수로 주어진다.
 * 이때 입력으로 주어지는 N은 항상 K보다 크거나 같다.
 * 출력조건::
 * 첫째줄에 N이 1이될때까지 1번 혹은 2번의 과정을 수행해야하는 횟수의 최솟값을출력한다.
 * 입력 예시    출력 예시
 * 25 5         2
 */
public class 일이될때까지 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        if(N < K || (N < 2 || N > 100000) || (K < 2 || K > 100000)){
            System.out.println("입력 값이 정해진 범위를 초과했습니다.");
            System.exit(0);
        }

        int result = 0;
        while(true){
            if(N==1) break;
            if(N%K == 0) N = N/K;
            else         N -=1;
            result++;
        }

        //수식이 잘 이해가 안감 ㅜ
//        while(true){
//            int target = N/K * K;   //17/4 * 4 = 16
//            result += N - target;   //17-16 = 1
//            N = target;             // 16
//            if(N<K) break;
//            result += 1;            // 2
//            N = N/K;                // N = 4
//        }
//        result += N-1;


        System.out.println(result);
    }
}
