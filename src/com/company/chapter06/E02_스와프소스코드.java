package com.company.chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E02_스와프소스코드 {
    public static void main(String[] args) {
        //굳이 콜렉션을 써야하는게 더 부담스러운거같기두하고. 하지만 이름자체가 스왑이라 보기 편함
        Integer[] array = {1,2};
        List<Integer> a = Arrays.asList(array);
        Collections.swap(a,0,1);

        System.out.println(a.toString());

        //이게 친숙하다
        int[] array2 = {3,4};
        int temp = 0;
        temp = array2[0];
        array2[0] = array2[1];
        array2[1] = temp;

        System.out.println(Arrays.toString(array2));
    }
}
