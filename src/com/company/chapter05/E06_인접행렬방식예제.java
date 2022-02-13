package com.company.chapter05;

import java.util.Arrays;

public class E06_인접행렬방식예제 {
    public static void main(String[] args) {
        //double inf = Double.POSITIVE_INFINITY;
        int inf = Integer.MAX_VALUE;

        int[][] graph = {{0,7,5},
                        {7,0,inf},
                        {5,inf,0}};
                                                        //1차원은 Arrays.toString deepToString은 다차원
        System.out.println(Arrays.deepToString(graph)); //[[0, 7, 5], [7, 0, 2147483647], [5, 2147483647, 0]]
    }
}
