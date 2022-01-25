package com.company.chapter04;

import java.util.Arrays;
import java.util.Scanner;

public class E01_상하좌우 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nt = scan.nextLine();
        int n = Integer.parseInt(nt);
        String[] moveArray = scan.nextLine().split(" ");

        int x = 1 ,y = 1;
        // x, y는 행렬 좌표값으로 볼 수 있다..
        // L이면 왼쪽으로 이동하기때문에 열 값이 하나 감소,
        // R이면 오른쪽으로 이동하기때문에 열 값이 하나 증가,
        // U이면 위쪽으로 이동하기때문에 행 값이 하나 감소,
        // D이면 아래쪽으로 이동하기때문에 행 값이 하나 증가.
        for(String dir : moveArray){
            if(dir.equals("L") && y > 1 ) y--;
            else if(dir.equals("R") && y < n) y++;
            else if(dir.equals("U") && x > 1) x--;
            else if(dir.equals("D") && x < n) x++;
        }


        System.out.printf("%d %d",x,y);

    }
}
