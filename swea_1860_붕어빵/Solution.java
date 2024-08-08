package SWEA_1860_진기의최고급붕어빵;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// N, M, K 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			// 손님 도착 시간 입력
			int[] customers = new int[N];
			for (int i=0; i<N; i++) {
				customers[i] = sc.nextInt();
			}
			
			// 오는 순서대로 정렬
			Arrays.sort(customers);
			
			String result = "Possible";
			// 장사 가능한지 검사
			for (int i=0; i<N; i++) {
				int bread = (customers[i]/M)*K - (i+1);
				if (bread<0) {
					result = "Impossible";
					break;
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + result);
		}
	}
}