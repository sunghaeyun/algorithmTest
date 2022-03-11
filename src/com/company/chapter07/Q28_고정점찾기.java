package com.company.chapter07;

public class Q28_고정점찾기 {
    static int idx = -1;
    public static void main(String[] args) {
//        int n = 5;
//        int[] arr = {-15,-6,1,3,7};
//        int n = 7;
//        int[] arr = {-15,-4,2,8,9,13,15};
        int n = 7;
        int[] arr = {-15,-4,3,8,9,13,15};

        System.out.println(binarySearch(arr, 0, arr.length-1));
    }

    public static int binarySearch(int[] arr, int start, int end){
        while(start <= end){
            int mid = (start+end)/2;
            //인덱스랑 원소의 값이 같을 경우 리턴
            if(arr[mid] == mid){
                idx = mid;
                return idx;
            }
            //원소의 값이 인덱스보다 크면 왼쪽 이동
            else if(arr[mid] > mid){
                end = mid - 1;
                binarySearch(arr, start, end);
            }
            //원소의 값이 인덱스보다 작으면 오른쪽 이동
            else{
                start = mid+1;
                binarySearch(arr, start, end);
            }
        }
        //인덱스를 리턴. 찾은바가 없으면 초기값 -1 리턴.
        return idx;
    }
}
