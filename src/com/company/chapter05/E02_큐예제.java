package com.company.chapter05;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class E02_큐예제 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        queue.poll();
        queue.offer(1);
        queue.offer(4);
        queue.poll();

        System.out.println(queue);  //[3,7,1,4] 들어온순서대로 출력
        System.out.println(reverseQueue(queue));    //[4,1,7,3] 최근순으로

        // 스택과 큐를 합친 데크.
        //Deque 인터페이스에 정의되어있음. 구현한 클래스가 여러가지라 아래처럼 사용가능.
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ConcurrentLinkedDeque<>();
        Deque<Integer> deque3 = new LinkedBlockingDeque<>();
        Deque<Integer> deque4 = new LinkedList<>();

        //앞쪽에 데이터를 넣고 뒤쪽에서 빼면 큐처럼 사용가능.
        //앞쪽에 넣고 다시 앞쪽에서 빼면 스택처럼 사용가능.
        //한쪽으로만 입력이 가능하도록 설정한 덱은 스크롤(Scroll)
        //한쪽으로만 출력할 수 있도록 설정한 덱을 셸프(Shelf)
        deque1.addFirst(1);     //앞쪽에 데이터 삽입. 용량 초과시 Exception
        deque1.addLast(3);      //뒤쪽에 데이터 삽입, 용량 초과시 Exception
        deque1.push(7);         // =addFirst
        deque1.add(4);             // =addLast

        deque1.offerFirst(2);   //앞쪽에 데이터 삽입 후 true, 용량 초과 시 false
        deque1.offerLast(5);    //뒤쪽에 데이터 삽입 후 true, 용량 초과 시 false
        deque1.offer(6);        // =offerLast

        deque1.pop();              // =removeFirst

        System.out.println(deque1); //[7, 1, 3, 4, 5, 6]

        //https://hbase.tistory.com/128 참고
    }

    //큐를 스택에 담고 다시 스택에서 큐로 담으면 역순이 된다...!
    private static Queue reverseQueue(Queue q){

        Stack stack = new Stack();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
        return q;
    }
}
