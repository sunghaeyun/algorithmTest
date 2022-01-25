package com.company.chapter04;

import java.util.Scanner;

public class E02_왕실의나이트 {
    public static void main(String[] args) {

        /***
         * 나이트가 움직일 수 있는 방법은 두가지.
         * 수평 2칸 수직1칸, 수직2칸 수평1칸
         * 8X8칸 체스판.
         * a=97
         * h=104
         */

        Scanner scanner = new Scanner(System.in);
        String location = scanner.nextLine();
        //char로 받아서 96을 빼줬음 (a : 97-96 =1, h : 104 - 96 = 8)
        int col = location.substring(0,1).charAt(0) - 96;
        int row = Integer.parseInt(location.substring(1,2));

        //나이트가 움직일 수 있는 경우의 수
        int[][] type = {{-2,-1},{-2,1},{-1,2},{1,2},{2,-1},{2,1},{-1,-2},{1,-2}};

        int cnt =0;

        //나이트가 움직일 수 있는지 확인 후 카운트.
        for(int i=0; i<type.length; i++){
            if(col+type[i][0] > 0 && row+type[i][1] > 0 ) cnt++;
        }

        System.out.println(cnt);
    }
}
