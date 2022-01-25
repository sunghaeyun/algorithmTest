package com.company.chapter04;

import java.util.Scanner;

public class E01_상하좌우_EX {
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

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        String[] type = {"L","R","U","D"};

        ///그냥하면 시간복잡도가 O(N)인데 이건 O(N^2)아닌가? 왜 이렇게 하는지 모르겠음.
        for(String dir : moveArray){
            int nx = 0, ny = 0;
            for(int i =0; i<type.length; i++){
                if(dir.equals(type[i])){
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }
            if(nx<1||ny<1||nx>n||ny>n) continue;
            x = nx; y = ny;
        }


        System.out.printf("%d %d",x,y);

    }
}
