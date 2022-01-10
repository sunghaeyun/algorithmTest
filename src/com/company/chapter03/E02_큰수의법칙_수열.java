package com.company.chapter03;

import java.util.Arrays;

public class E02_큰수의법칙_수열 {
    public static void main(String[] args) {
        int[] fstLine = {5, 8, 3};
        int[] scdLine = {2,4,5,4,6};

        int[] sortedScdLine = Arrays.stream(scdLine).sorted().toArray();

        int max = sortedScdLine[scdLine.length -1];
        int max2 = sortedScdLine[scdLine.length -2];

        // 반복되는 수열을 사용하여 해결하는 방법.
        // 첫번째라인의 두번째 숫자(m)만큼 사용하고, 세번째숫자(k)만큼 연속으로 사용할 수 있음.
        // 따라서 최대값을 구하기위해서는 제일 큰 수를 k만큼 사용하고 그다음엔 두번째로 큰 수를 더하고
        // 이후 다시 제일 큰수를 k만큼 사용하는걸 반복하는 방법.
        // 즉 k+1만큼이 반복된다.
        // 따라서 m을 k+1로 나눈 몫만큼 (제일큰수*k + 두번째로큰수)를 반복하고, 나머지만큼 제일 큰수를 더해주면 된다.
        int result = (fstLine[1]/(fstLine[2]+1)) * (max * 3 + max2) + (fstLine[1]%(fstLine[2]+1)) * max;

        System.out.println(result);
    }
}
