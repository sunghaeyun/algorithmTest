package com.company.chapter05;

import java.util.Stack;

public class E01_스택예제 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        System.out.println(stack);  // [5,2,3,1] 들어간순서대로 출력
        while(!stack.isEmpty()){    // 1325       상단부터 출력
            System.out.print(stack.pop());
        }
    }
}
