package com.company.chapter06;

import java.util.*;
import java.util.stream.Collectors;

public class EQ02_성적이낮은순서로학생출력 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        ArrayList<Map<String, Integer>> data = new ArrayList<>();

//        String[] name = new String[N];
//        int[] score = new int[N];
//        for(int i = 0 ;i<N; i++){
//            String temp = scan.nextLine();
//            String[] tempArr = temp.split(" ");
//            name[i] = tempArr[0];
//            score[i] = Integer.parseInt(tempArr[1]);
//        }
//
//        //삽입정렬
//        for(int i = 1; i<score.length; i++){
//            for(int j = i; j>0; j--){
//                if(score[j] < score[j-1]){
//                    int temp = score[j-1];
//                    score[j-1] = score[j];
//                    score[j] = temp;
//
//                    String tempStr = name[j-1];
//                    name[j-1] = name[j];
//                    name[j] = tempStr;
//                }else{
//                    break;
//                }
//            }
//        }


        //TreeMap으로 정렬
        Comparator<String> comparator = (s1, s2)->s1.compareTo(s2); //s2.compareTo(s1) 요거는 내림차순
        Map<String, Integer> map = new TreeMap<>(comparator);
        for(int i = 0 ;i<N; i++){
            String temp = scan.nextLine();
            String[] tempArr = temp.split(" ");
            map.put(tempArr[0], Integer.parseInt(tempArr[1]));
        }

        System.out.println(map);

    }
}
