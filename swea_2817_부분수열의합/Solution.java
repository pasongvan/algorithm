package swea_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	
	// 전역변수
	static int[] numbers;
	static int N;
	static int K;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			N = sc.nextInt();
			K = sc.nextInt();
			numbers = new int[N];
			for (int i=0; i<N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			// 메소드 호출
			cnt = 0;
			method(0, -1);
			
			// 결과 출력
			System.out.println("#" + test_case + " " + cnt);
		}

	}
	
	static void method(int sum, int last) {
		
		// 기저조건1: 합이 K일 때
		if (sum == K) {
			cnt++;
			return;
		}
		
		// 기저조건2: last가 N-1일 때
		if (last == N-1) {
			return;
		}
		
		
		// 재귀 부분
		for (int i=last+1; i<N; i++) {
			method(sum+numbers[i], i);
		}
	}

}
