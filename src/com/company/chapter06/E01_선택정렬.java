package com.company.chapter06;

import java.util.Arrays;

//시간 복잡도 O(N^2)
public class E01_선택정렬 {
    public static void main(String[] args) {
        int[] array = {7,5,9,0,3,1,6,2,4,8};
        int min = 0;
        int temp = 0;
        for(int i = 0; i<array.length; i++){
            min = i;
            for(int j=i+1; j< array.length; j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
