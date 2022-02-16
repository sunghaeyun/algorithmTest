package com.company.chapter05;

public class Q16_연구소 {
    static int N = 7;
    static int M = 7;
    static int[][] data = {{2,0,0,0,1,1,0},
                            {0,0,1,0,1,2,0},
                            {0,1,1,0,1,0,0},
                            {0,1,0,0,0,0,0},
                            {0,0,0,0,0,1,1},
                            {0,1,0,0,0,0,0},
                            {0,1,0,0,0,0,0}};
    static int[][] afData = new int[7][7];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int result = 0;
    public static void main(String[] args) {
        //모든 경우의수를.... 돌려서 결과를 찾다니.....
        dfs(0);
        System.out.println(result);
    }

    //바이러스 퍼뜨리기
    private static void virus(int x, int y){
        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽을 안 뚫고 가는지 확인
            if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                //빈칸이면
                if(afData[nx][ny] == 0){
                    //바이러스 침투
                    afData[nx][ny] = 2;
                    //다음 바이러스 고
                    virus(nx,ny);
                }
            }
        }
    }

    //안전영역 크기 계산
    private static int getScore(){
        int score = 0;
        for(int i=0; i<N; i++){
          for(int j=0; j<M; j++){
              //빈칸이면 더한다.
              if(afData[i][j] == 0) score++;
          }
        }
        return score;
    };

    private static void dfs(int count){
        //벽이 세개가 되면
        if(count == 3){
            //데이터를 복사함.
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    afData[i][j] = data[i][j];
                }
            }
            //각 바이러스 위치에서 전파시킴
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(afData[i][j]==2) virus(i,j);
                }
            }
            //안전영역 계산
            result = Integer.max(result, getScore());
            return;
        }

        //울타리 설치
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //빈칸이면
                if(data[i][j]==0){
                    data[i][j] =1; //벽을 세움
                    count++;        //벽개수 추가
                    dfs(count);     //재귀. 벽세개가 된다음 안전영역 최대값을 계속 result에 넣음.
                    data[i][j] = 0; //벽다시 부숨.
                    count--;        //벽개수 빼기
                }
            }
        }
    }
}
