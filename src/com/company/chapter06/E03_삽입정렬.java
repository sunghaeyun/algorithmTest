package com.company.chapter06;

import java.util.Arrays;

//시간 복잡도 O(N^2)
public class E03_삽입정렬 {
    public static void main(String[] args) {
        int[] arr = {7,5,9,0,3,1,6,2,4,8};

        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }else{
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
