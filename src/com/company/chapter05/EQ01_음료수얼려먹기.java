package com.company.chapter05;

import java.util.ArrayList;

public class EQ01_음료수얼려먹기 {
    static int[][] move = {{0,-1},{1,0},{0,1},{-1,0}};
    static ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> dataArray = new ArrayList<>();
    static int icecream = 0;
    static int N = 4;
    static int M = 5;
    public static void main(String[] args) {

        String[] data = {"00110", "00011", "11111", "00000"};


        for (int i = 0; i < N; i++) {
            dataArray.add(new ArrayList<>());
          //  visited.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dataArray.get(i).add(Integer.parseInt(data[i].substring(j, j + 1)));
               // visited.get(i).add(false);
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j=0; j<M; j++){
                if (dfs(i, j)) {
                    icecream += 1;
                }
            }
        }

        //dfs(0,0);
        System.out.println(dataArray);
        System.out.println(icecream);
    }
    private static Boolean dfs(int x, int y){
        //네 방향 점검
//        for(int k=0; k<4; k++){
//            int tempX = x + move[k][0];
//            int tempY = y + move[k][1];
//            if(tempX < 0 || tempY < 0) continue;
//            else if(dataArray.get(tempX).get(tempY) == 0){
//                if(!visited.get(tempX).get(tempY)){
//                    visited.get(tempX).set(tempY, true);
//                    System.out.println(tempX+", "+tempY+"노드를 방문합니다.");
//                    dfs(tempX, tempY);
//                    System.out.println(tempX+", "+tempY+"노드를 방문을 종료합니다.");
//                }
//            }
//        }
//
        if(x < 0 || x >= N || y < 0 || y >= M){
            return false;
        }

        if(dataArray.get(x).get(y) == 0){
            dataArray.get(x).set(y,1);
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;

    }
//    private static void dfs(int x, int y){
//        //방문처리
//        visited.get(x).set(y, true);
//
//        for(int i = 0; i<N; i++){
//            System.out.println("N은 "+i+"번째");
//            for(int j=0; j<M; j++){
//                System.out.println("M은 "+j+"번째");
//                //네 방향 점검
//                for(int k=0; k<4; k++){
//                    int tempX = x + move[k][0];
//                    int tempY = y + move[k][1];
//                    if(tempX < 0 || tempY < 0) continue;
//                    else if(dataArray.get(tempX).get(tempY) == 0){
//                        if(!visited.get(tempX).get(tempY)){
//                            visited.get(tempX).set(tempY, true);
//                            System.out.println(tempX+", "+tempY+"노드를 방문합니다.");
//                            dfs(tempX, tempY);
//                            System.out.println(tempX+", "+tempY+"노드를 방문을 종료합니다.");
//                        }
//                    }
//                }
//
//            }
//
//        }
//
//
//    }
}
