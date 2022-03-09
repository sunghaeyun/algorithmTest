package com.company.chapter07;

import java.util.Arrays;
import java.util.stream.IntStream;

public class EQ02_떡볶이떡만들기 {
    static int tteokArr[] = {19, 15, 10, 17};

    public static void main(String[] args) {
        int n = 4;
        int m = 6;

        //주어진 떡 길이
        tteokArr = Arrays.stream(tteokArr).sorted().toArray();
        // 길이 array
        int[] cmArray = IntStream.rangeClosed(0, tteokArr[n-1]).toArray();

        System.out.println(binarySearch(cmArray, m, 0, cmArray.length-1));

    }

    //이진탐색 재귀함수
    public static int binarySearch(int[] array, int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2; //int형이라 소수점 버려짐
            //System.out.println("mid:"+mid);
            int sum = sumCut(array[mid]); //잘라진 부분 더하기
            //System.out.println("sum:"+sum);
            if(sum == target) return array[mid];
            else if (sum < target){
                //잘라서 더한 값이 목표값보다 작으면 더 많이 잘라야함.  자르는 cm 기준이 작아야 잘라내서 더해지는 값이 커짐.
                //일반 이진탐색은 값을 찾기 때문에 찾는 값이 중앙값보다 크면 end를 중앙값 이하로(왼쪽으로)변경하지만,
                //현재는 값을 찾는게 아니라 떡을 자르는 cm기준을 찾는 것.
                // 떡을 자르는 기준이 작아지면 잘라진 떡의 길이가 길어짐.
                // 떡을 자르는 기준이 커지면   잘라진 떡의 길이가 짧아짐.
                // =>그래서 목표치보다 잘라진 떡의 길이(더한 값)가 더 작다면, 떡을 자르는 기준을 더 작게 해야함
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

    // 자르는 기준 입력해서 잘라진 떡의 길이를 더함.
    public static int sumCut(int cutCm){
        int sum=0;
        for(int i=0; i<tteokArr.length; i++){
            if(tteokArr[i] >= cutCm ) sum+= (tteokArr[i] - cutCm);
        }
        return sum;
    }
}
