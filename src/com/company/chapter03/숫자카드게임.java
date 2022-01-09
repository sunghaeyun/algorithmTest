package com.company.chapter03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.*;


public class 숫자카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String[] fstLine = sc.nextLine().split(" ");
        int[] fstLineInt = Arrays.stream(fstLine).mapToInt(Integer::parseInt).toArray();
        int n = fstLineInt[0];
        int m = fstLineInt[1];



        HashMap minMap = new HashMap<>();
        int idx = 0;
        int temp = 0;
        int resultIdx = 0;

        while(idx<n){
            String[] line = sc.nextLine().split(" ");
            int min = Arrays.stream(line).mapToInt(Integer::parseInt).min().getAsInt();
            if(temp < min){
                temp = min;
                resultIdx = idx;
            }
            idx++;
        }

        out.println(temp);          //그값 구할 때
        out.println(resultIdx+1);   //인덱스구할때

        //행렬만드는용...
        //        int idx2;
        //        int temp = 100;
        //        int[] minArray = new int[n];
        //int[][] intMatrix = new int[n][m];
//        try {
//            while (idx < n) {
//                String[] line = sc.nextLine().split(" ");
//                int[] lineInt = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
//                idx2 = 0;
//                temp = 100;
//                while (idx2 < m) {
//                    if (temp > lineInt[idx2]) temp = lineInt[idx2];
//                    //intMatrix[idx][idx2] = lineInt[idx2];
//                    idx2++;
//                }
//                minArray[idx] = temp;
//                minMap.put(temp, idx);
//                idx++;
//            }
//        }catch (IndexOutOfBoundsException e){
//            out.println("n * m 행렬로 입력해야 합니다.");
//            exit(0);
//        }

        //하지만 쓸일이음슴!
        //행렬 확인용
//        idx = 0;
//        while (idx<n) {
//            idx2=0;
//            while (idx2<m) {
//                out.print(intMatrix[idx][idx2]+" ");
//                idx2++;
//            }
//            out.println();
//            idx++;
//        }

        //최소값배열 확인용
//        idx=0;
//        while(true){
//            if(idx >= n) break;
//            out.println(minArray[idx]+" ");
//            idx++;
//        }

//        int result = Arrays.stream(minArray).max().getAsInt();
//        out.println((int)minMap.get(result)+1);
    }
}
