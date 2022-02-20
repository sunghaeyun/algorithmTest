package com.company.chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class EQ03_두배열의원소교체 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        String[] tempArr = temp.split(" ");
        int N = Integer.parseInt(tempArr[0]);
        int K = Integer.parseInt(tempArr[1]);

        int[] origin = new int[N];
        int[] change = new int[N];

        for(int i = 0 ;i<2; i++){
            String temp1 = scan.nextLine();
            String[] tempArr1 = temp1.split(" ");
            for(int j=0; j<N; j++){
                if(i==0) origin[j] = Integer.parseInt(tempArr1[j]);
                else      change[j] = Integer.parseInt(tempArr1[j]);
            }
        }

        //선택정렬 오름차순
        int min = 0;
        int temp1 = 0;
        for(int i = 0; i<origin.length; i++){
            min = i;
            for(int j=i+1; j< origin.length; j++){
                if(origin[min] > origin[j]){
                    min = j;
                }
            }
            temp1 = origin[i];
            origin[i] = origin[min];
            origin[min] = temp1;
        }

        //삽입정렬 내림차순
        for(int i=1; i<change.length; i++){
            for(int j=i; j>0; j--){
                if(change[j] > change[j-1]){
                    temp1 = change[j-1];
                    change[j-1] = change[j];
                    change[j] = temp1;
                }else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(change));

        //K개만큼교환
        for(int i=0; i<K; i++){
            temp1 = origin[i];
            origin[i] = change[i];
            change[i] = temp1;
        }

        System.out.println(Arrays.stream(origin).sum());

    }

}
