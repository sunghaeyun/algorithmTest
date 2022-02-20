package com.company.chapter06;

import java.util.Arrays;
import java.util.Scanner;

public class EQ01_위에서아래로 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        int[] intArr = new int[N];
        for(int i = 0 ;i<N; i++){
            intArr[i] = Integer.parseInt(scan.nextLine());
        }

        //선택정렬
        int min = 0;
        int temp = 0;
        for(int i=0; i<intArr.length; i++){
            min = i;
            for(int j=i+1; j< intArr.length; j++){
                if(intArr[min] > intArr[j]){
                    min = j;
                }
            }
            temp = intArr[i];
            intArr[i] = intArr[min];
            intArr[min] = temp;
        }

        System.out.println(Arrays.toString(intArr));

    }
}
