package com.company.chapter06;

import java.util.Arrays;

//시간 복잡도 O(NlogN)
public class E04_퀵정렬 {
    static int[] arr = {5,7,9,0,3,1,6,2,4,8};

    static int pivot = 0;
    static int left = 0;
    static int right = 0;
    static int temp = 0;
    static private void quick_sort(int start, int end){
        if(start >= end){
            return;
        }
        pivot = start;  //피벗은 첫번째 인덱스로
        left = start+1; // 왼쪽에서 찾는건 피벗 바로 다음꺼부터
        right = end;    // 오른쪽에서 찾는건 제일 마지막 인덱스부터


        while(left <= right){ //왼쪽 인덱스값이 오른쪽값보다 커지면 종료된다.
            //왼쪽값이 end보다 작고, 왼쪽값이 피벗보다 작거나 같으면 왼쪽값 계속 진행 -> 피벗보다 큰값이 나오면 멈춤
            while(left<=end && arr[left] <= arr[pivot]){
                left++;
            }
            //오른쪽값이 start보다 커야하고, 오른쪽값이 피벗보다 크거나 같으면 계속 진행 ->피벗보다 작은값이 나오면 멈춤
            while(right> start && arr[right] >= arr[pivot]){
                right--;
            }

            //while문 돌려서 찾은 왼쪽 오른쪽이 엇갈렸다면 작은 값을 피벗과 교체
            if(left > right){
                temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }
            //안 엇갈렸다면 작은 데이터와 큰 데이터를 교체
            else{
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //분활 된 다음에 왼쪽과 오른쪽 부분을 다시 각각 정렬 수행한다.
        //위에 while문이 left<=right 조건이기 때문에 오른쪽값이 더 작을 때 탈출한다. 오른쪽값에 피벗이 자리잡기때문에
        //왼쪽부분은 0부터 피벗 직전값(right-1), 오른쪽부분은 피벗 직후값(right+1)부터 끝까지
        quick_sort(start, right -1);
        quick_sort(right+1, end);
    }

    public static void main(String[] args) {
        quick_sort(0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
