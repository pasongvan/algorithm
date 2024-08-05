package boj_1743_음식물;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 설정 및 입력==================================================
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int max = 0;
		int[][] floor = new int[N+2][M+2]; // 인덱스 범위 벗어나지 않도록 테두리 0
		for (int i=0; i<K; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			floor[row][col] = 1;
		}
		
		// 음식물 크기 계산==================================================
		// 모든 칸 순회
		for (int row=1; row<=N; row++) {
			for (int col=1; col<=M; col++) {
				// 내 칸에 음식물이 있을 때
				if (floor[row][col] > 0) {
					
					// 위, 왼쪽, 위왼쪽에 모두 음식물이 있으면 (내 칸) - (왼쪽 위)
					if (floor[row-1][col]>0 && floor[row][col-1]>0 && floor[row-1][col-1]>0)
						floor[row][col] -= floor[row-1][col-1];
					
					// 최댓값 갱신
					if (max < floor[row][col])
						max = floor[row][col];
					
					// 오른쪽이나 아래쪽에 음식물이 있는 경우
					if (floor[row][col+1]>0 || floor[row+1][col]>0) {
						//나, 오른쪽, 아래쪽 다 더한 값을
						int sum = floor[row][col] + floor[row][col+1] + floor[row+1][col];
						// 오른쪽에 저장
						if (floor[row][col+1] > 0) {
							floor[row][col+1] = sum;
						}
						// 아래쪽에 저장
						if (floor[row+1][col] > 0) {
							floor[row+1][col] = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
