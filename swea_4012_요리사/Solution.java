package swea_4012_요리사;

import java.util.Scanner;

public class Solution {
	
	// 전역 변수
	static int[][] synergies;
	static int[] peeked;
	static int N;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			N = sc.nextInt();
			synergies = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					synergies[i][j] = sc.nextInt();
				}
			}
			
			// 전역 변수 초기화
			min = Integer.MAX_VALUE;
			peeked = new int[N];
			
			// 메소드 호출
			method1(-1, 0);
			
			// 결과 출력
			System.out.println("#" + test_case + " " + min);
		}
		

	}
	static void method1(int last, int depth) {
		// 기저조건
		if (depth == N/2) {
			int diff = method2();
			
			// 최솟값 갱신
			if (min > diff)
				min = diff;
			
			return;
		}
		
		// 재귀 부분
		for (int i=last+1; i<N-(N/2-depth); i++) {
			peeked[i] = 1;
			method1(i, depth+1);
			peeked[i] = 0;
		}
	}
	
	// 시너지 계산 메소드
	static int method2() {
		// 택하지 않은 조합 구하기
		int[] unpeeked = new int[N];
		for (int i=0; i<N; i++) {
			unpeeked[i] = 1 - peeked[i];
		}
		
		// peeked 맛 점수 구하기
		int sum_peeked = 0;
		for (int i=0; i<N-1; i++) {
			if (peeked[i] == 0)
				continue;
			for (int j=i+1; j<N; j++) {
				if (peeked[j] == 0)
					continue;
				sum_peeked += synergies[i][j] + synergies[j][i]; 
			}
		}
		// unpeeked 맛 점수 구하기
		int sum_unpeeked = 0;
		for (int i=0; i<N-1; i++) {
			if (unpeeked[i] == 0)
				continue;
			for (int j=i+1; j<N; j++) {
				if (unpeeked[j] == 0)
					continue;
				sum_unpeeked += synergies[i][j] + synergies[j][i];  
			}
		}
		
		// 차이 계산
		int diff = sum_peeked - sum_unpeeked;
		if (diff < 0)
			diff *= -1;
		
		return diff;
	}
}




