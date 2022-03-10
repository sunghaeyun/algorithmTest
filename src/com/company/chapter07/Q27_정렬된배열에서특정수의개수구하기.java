package com.company.chapter07;

public class Q27_정렬된배열에서특정수의개수구하기 {
    static int idx = -1;
    public static void main(String[] args) {
        int n = 7;
        int x = 2;
        int[] arr = {1,1,2,2,2,2,3};
//        int n = 7;
//        int x = 4;
//        int[] arr = {1,1,2,2,2,2,3};

        // 1. 이진탐색으로 x가 몇번째 index에서 시작하는지를 찾음
        int stIdx = binarySearch(arr,x,arr[0],arr[n-1]);
        // 2. 배열안에 해당 값이 존재하면, for문으로 x가 시작하는 index에서 순차적으로 다른값이 나올 때까지 더해서 구한다.
        if(stIdx > 0){
            int sum=0;
            System.out.println("시작 index는 "+stIdx);
            for(int i=stIdx; i<arr.length; i++){
                if(arr[i] == x ) sum++;
                else            break;
            }
            System.out.println(x+"는 "+sum+"번 출력 됨");
        }
        else{
            System.out.println(-1);
        }

    }

    //x가 시작하는 index 찾기
    public static int binarySearch(int[] arr, int target, int start, int end){
        if(start == end) return idx;
        while(start < end){
            int mid = (start+end)/2;
            //찾는값이랑 같으면 idx에 회당 인덱스를 넣음.
            if(arr[mid] == target) idx = mid;
            if(arr[mid] <= target){
                end = mid -1;
                binarySearch(arr, target, start, end);
            }
            else{
                start = mid + 1;
                binarySearch(arr, target, start, end);
            }
        }
        return idx;
    }
}
