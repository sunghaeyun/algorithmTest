package com.company.chapter04;

import java.util.Scanner;

public class E02_시각 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int cnt = 0;

        for(int h = 0; h<=n; h++){
            for(int m = 0; m <60; m++){
                for(int s = 0; s < 60; s++){
                    if((String.valueOf(h)+String.valueOf(m)+String.valueOf(s)).indexOf("3") >= 0) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
