package com.company.chapter07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EQ01_부품찾기 {
    int n1 = 5;
    int[] hasArr = {8,3,7,9,2};
    int n2 = 3;
    int[] reqArr = {5,7,9};
    public static void main(String[] args) {
        int n1 = 5;
        int[] hasArr = {8,3,7,9,2};
        int n2 = 3;
        int[] reqArr = {5,7,9};

        
        //1. 이진탐색
        //오름차순 정렬
        hasArr = Arrays.stream(hasArr).sorted().toArray();
        //reqArr = Arrays.stream(reqArr).sorted().toArray(); 요구한건 정렬할필요가없음..

        for(int i=0; i<n2; i++){
            boolean find = binarySearch(hasArr,reqArr[i],0,hasArr.length-1) > 0? true : false;
            System.out.println(binarySearch(hasArr,reqArr[i],0,hasArr.length-1));
            System.out.println(reqArr[i] + "번 부품은 "+find);
        }
        //출력
//        0
//        5번 부품은 false
//        2
//        7번 부품은 true
//        4
//        9번 부품은 true

        //2. 자료형으로 찾기
        Set<Integer> integerSet = new HashSet<>();
        for(int i=0; i<n1; i++){
            integerSet.add(hasArr[i]);
        }

        for(int i=0; i<n2; i++){
            boolean find = integerSet.contains(reqArr[i]);
            System.out.println(reqArr[i] + "번 부품은 "+find);
        }
//        5번 부품은 false
//        7번 부품은 true
//        9번 부품은 true

    }

    //이진탐색 재귀함수
    public static int binarySearch(int[] array, int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2; //int형이라 소수점 버려짐
            if(array[mid] == target) return mid;
            else if (array[mid] > target){
                end = mid -1;
                binarySearch(array, target, start, end);
            }
            else{
                start = mid + 1;
                binarySearch(array, target, start, end);
            }
        }
        return 0;
    }
}
