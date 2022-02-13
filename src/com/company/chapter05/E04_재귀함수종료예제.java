package com.company.chapter05;

public class E04_재귀함수종료예제 {
    public static void main(String[] args) {
        recursive_function(1);
    }
    private static void recursive_function(int i){
        if(i==100){
            return;
        }
        System.out.println(i+"번째 재귀함수에서 "+(i+1)+"번째 재귀함수를 호출합니다.");
        recursive_function(i+1);
        System.out.println(i+"번째 재귀함수를 종료합니다.");
    }
}
