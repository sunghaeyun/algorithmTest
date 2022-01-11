package com.company.chapter03;

import java.util.Arrays;

public class Q06_무지의먹방라이브 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] food_times = {1,1,1};	//각 음식의 섭취시간. 배열의 크기는 음식의 수.
        int k = 5;		//몇초후 정전될지
        int result;		//결과

        int foodCnt = food_times.length;	//음식갯수
        int second =0;		//초
        int arrIdx = 0;		//배열 인덱스
        int zeroCnt = 0;	//다 먹은 음식 갯수. (배열에서 0이 된 인덱스의 수)
        //주어진 k초까지 반복
        while(second < k){
            //0보다 크면 배열에서 꺼낸 값을 하나 감소 시킴.
            if(food_times[arrIdx] > 0){
                food_times[arrIdx]--;
                second++;
            }
            //0이면 zeroCnt 증가시킴
            else{
                zeroCnt++;
            }
            //다먹은 음식 수가 전체 음식수랑 같으면 탈출
            if(zeroCnt == foodCnt)	break;

            //배열인덱스가 배열마지막인덱스면 인덱스를 0으로 바꿔둠.
            if(arrIdx == foodCnt-1)	arrIdx = 0;
                //아니면 배열인덱스를 증가시킴;
            else								arrIdx++;
        }

        result = Arrays.stream(food_times).filter(i-> i>0).count() == 0?-1:arrIdx+1;
        System.out.println(result);
    }

}