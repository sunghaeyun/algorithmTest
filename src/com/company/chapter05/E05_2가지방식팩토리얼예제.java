package com.company.chapter05;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E05_2가지방식팩토리얼예제 {
    public static void main(String[] args) {
        //n을 입력했을 때 n!을 구하는 방법 두가지.
        //1. 반복으로 구현
        System.out.println(factorial_iterative(3));
        //2. 재귀함수로 구현
        System.out.println(factorial_Recursive(3));

    }

    private static int factorial_iterative(int n){
        //stream 참고 https://futurecreator.github.io/2018/08/26/java-8-streams/
        int result = IntStream.rangeClosed(1, n).reduce((x, y) -> x * y).getAsInt();
//        int result = IntStream.range(1, n+1) // [1, 2, 3]
//                        .reduce(0, Integer::sum); //이건 다 더하기
        return result;
    }

    private static int factorial_Recursive(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial_Recursive(n-1);
    }
}
