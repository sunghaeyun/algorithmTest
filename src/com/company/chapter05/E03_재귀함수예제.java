package com.company.chapter05;

public class E03_재귀함수예제 {
    public static void main(String[] args) {
        recursive_function();
    }
    private static void recursive_function(){
        System.out.println("재귀함수를 호출합니다.");
        recursive_function();
    }
}
