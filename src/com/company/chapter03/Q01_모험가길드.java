package com.company.chapter03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q01_모험가길드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			long first = System.nanoTime();
			Scanner scan = new Scanner(System.in);

			String nt = scan.nextLine();
			int n = Integer.parseInt(nt);
			String moArray = scan.nextLine();
			int[] moFearIdx = Arrays.stream(moArray.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

			// Arrays forEach테스트해봄.
//			Arrays.stream(moFearIdx).filter(i -> n < i).forEach(i->{ System.out.println("오입력"); System.exit(0); });
//			Arrays.stream(moFearIdx).filter(i -> n < i).forEach(System::exit);
			//IntStream.range(0, 10).forEach(System.out::println);
			
			//몇초나오는지 계산해봄
//			int n = 100000;
//			int[] moFearIdx = new int[n];
//			Random rd = new Random();
//			rd.setSeed(System.currentTimeMillis());
//			for(int i=0; i<n; i++){
//				moFearIdx[i] = rd.nextInt(100000);
//			}
			
			
			if(n != moFearIdx.length) {
				System.out.println("오입력");
				System.exit(0);
			}
			
			int max;		//현재 공포도가 제일 높은 모험가의 수치
			int cnt = 0;	//그룹 수
			int idx = n-1;	//max의 index;
			while(true){
				if(idx < 0) break;		//index가 0 이하일 경우 종료
				max = moFearIdx[idx];	//index로 max값 찾기
				if(n < max) break;		//남은 모험가의 수가 max보다 작을 경우, 더 이상 그룹을 만들지 않고 남은 모험가를 마을에 잔존시킨다.
				idx -= max;				//공포도 수만큼 그룹이 만들어지기 때문에 인덱스에서 max값을 제해준다. 그룹을 만들고 남은 모험가 중의 공포도 최대값을 찾기 위함.
				n -= max;				//그룹을 만든 모험가의 수를 제해주기.
				cnt++;					//그룹의 수 카운트.
			}
			
			System.out.println(cnt);
			//System.out.println((double)(System.nanoTime() - first)/1000000000);
	}

}
