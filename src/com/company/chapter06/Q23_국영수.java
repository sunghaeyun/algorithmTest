package com.company.chapter06;

import com.sun.source.tree.Tree;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 12
 * Junkyu 50 60 100
 * Sangkeun 80 60 50
 * Sunyoung 80 70 100
 * Soong 50 60 90
 * Haebin 50 60 100
 * Kangsoo 60 80 100
 * Donghyuk 80 60 100
 * Sei 70 70 70
 * Wonseob 70 70 90
 * Sanghyun 70 70 80
 * nsj 80 80 80
 * Taewhan 50 60 90
 */
public class Q23_국영수 {
    static int N;
    static int[][] karr;    // 국어 점수 정렬 처리할 2차배열. 계수정렬사용
    static int[][] earr;    // 영어 점수 정렬 처리할 2차배열. 계수정렬사용
    static int[][] marr;    // 수학 점수 정렬 처리할 2차배열. 계수정렬사용
    static ArrayList<Score> data = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = Integer.parseInt(scan.nextLine());
        karr = new int[100][N];
        earr = new int[100][N];
        marr = new int[100][N];
        //-1로 초기화
        for(int i=0; i<100; i++){
            for(int j=0; j<N; j++){
                karr[i][j] = -1;
            }
        }
        //이름 성적 score 클래스로 넣어주기

        for(int i=0; i<N; i++){
            String dataStr = scan.nextLine();
            String[] dataStrSplit = dataStr.split(" ");
            Score s = new Score(dataStrSplit[0], Integer.parseInt(dataStrSplit[1]),Integer.parseInt(dataStrSplit[2]), Integer.parseInt(dataStrSplit[3]));
            data.add(s);
        }


        karr = getCountingSort(karr,1);

        for(int i=99; i>=0; i--){
            int[] dupArray = Arrays.stream(karr[i]).filter(t-> t>-1).toArray();
//            System.out.println(i);
//if(dupArray.length>0)            System.out.println(Arrays.toString(dupArray));
            //해당 점수(인덱스값)받은 사람이 있는지
            //한명만 있을 때
            if(dupArray.length == 1){
                System.out.println(" "+data.get(karr[i][0]).name+" "+data.get(karr[i][0]).kor+" "+data.get(karr[i][0]).eng+" "+data.get(karr[i][0]).math);

            }
            //두명이상 있을 때
            else if(dupArray.length > 1){
                //영어점수로 비교하자 영어는 오름차순
                //오름차순 선택정렬
                int min = 0;
                int tem = 0;
                int[] temp = new int[dupArray.length];
                for(int j=0; j<dupArray.length; j++){
                    min = j;
//                    System.out.println(j);
//                    System.out.println(data.get(j).eng);
//                    System.out.println(data.get(j-1).eng);
                    for(int k=j+1; k< dupArray.length; k++){
                        if(data.get(dupArray[min]).eng > data.get(dupArray[k]).eng){
                            min = k;
                        }

                    }
                    tem = dupArray[j];
                    dupArray[j] = dupArray[min];
                    dupArray[min] = tem;
                }
//                System.out.println(Arrays.toString(dupArray));



                for(int j=0; j<dupArray.length; j++){
                    System.out.println(" "+data.get(dupArray[j]).name +" "+data.get(dupArray[j]).kor+" "+data.get(dupArray[j]).eng+" "+data.get(dupArray[j]).math);
                }
            }
        }

        //System.out.println(Arrays.toString(arr[50]));
    }

    private static int[][] getCountingSort(int[][] arr, int gubun){
        //점수 값을 인덱스로 삼아서 해당 인덱스로 배열이 담겨져있음. 중복값이 생기면 해당 배열에 첨부터 담긴다.
        for(int i=0; i<N; i++){
            Score newS = data.get(i);
            int key;
            if(gubun == 1) key = newS.kor;
            else if(gubun == 2) key = newS.eng;
            else key = newS.math;

            for(int j=0; j<arr[key].length; j++){
                if(arr[key][j] == -1){
                    arr[key][j] = i;
                    break;
                }
            }
        }
        return arr;
    }

//    private static void compare(int[][] arr, int gubun){
//        for(int i=99; i>=0; i--){
//            int length = Arrays.stream(arr[i]).filter(t-> t>-1).toArray().length;
//            //해당 점수(인덱스값)받은 사람이 있는지
//            //한명만 있을 때
//            if(length == 1){
//                System.out.println(" "+data.get(arr[i][0]).name);
//            }
//            //두명이상 있을 때
//            else if(length > 1){
//                //영어점수로 비교하자
//                int[][] tarr = getCountingSort(earr,gubun+1);
//                compare(tarr, gubun+1);
//            }
//        }
//    }
}

class Score{
    String name;
    int kor;
    int eng;
    int math;

    public Score(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


}
