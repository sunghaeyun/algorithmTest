package com.company.chapter06;

import java.util.Arrays;

//시간 복잡도 O(N+K)
//데이터 범위가 한정되어있다면 효과적. 중복값이 많으면 효과적.
public class E05_계수정렬 {
    public static void main(String[] args) {
        int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};
        int[] count = new int[Arrays.stream(arr).max().getAsInt()+1];

        for(int i = 0; i<arr.length; i++){
            count[arr[i]] +=1;
        }

        for(int i=0; i<count.length; i++){
            for(int j = 0; j<count[i]; j++){
                System.out.print(i + " ");
            }
        }
    }
}
