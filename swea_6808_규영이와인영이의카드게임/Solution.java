package swea_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	
	// static 변수
	static int[] kyu = new int[9];
	static int[] inn = new int[9];
	static int win;
	static int SUM = 171; // 1부터 18까지의 합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// 규영이 카드 입력 받기 (규영이 카드는 true, 인영이 카드는 false로 저장)
			boolean[] tmpCard = new boolean[19];
			for (int i=0; i<9; i++) {
				int tmp = sc.nextInt();
				tmpCard[tmp] = true;
				kyu[i] = tmp;
			}
			
			// 인영이 카드 배열 저장
			int tmpIdx = 0;
			for (int i=1; i<=18; i++) {
				if (!tmpCard[i])
					inn[tmpIdx++] = i;
			}
			
			// 인영이 카드 모든 순서에 대해 규영이가 이기는 횟수 계산
			win = 0;
			perm(0);
			
			// 지는 횟수는 9! - 이기는횟수
			int lose = 362880 - win;
			
			// 결과 출력
			System.out.println("#" + tc + " " + win + " " + lose);
		}

	}
	// 순열 구하기
	static void perm(int idx) {
		// 기저조건
		if (idx == 9) {
			// 승패 결정 메소드 호출
			judge();
			return;
		}
		
		// 재귀부분
		for (int i=idx; i<9; i++) {
			swap(idx, i);
			perm(idx+1);
			swap(idx, i);
		}
	}
	
	// swap 메소드
	static void swap(int idx1, int idx2) {
		int tmp = inn[idx1];
		inn[idx1] = inn[idx2];
		inn[idx2] = tmp;
	}
	
	// 승패 결정 메소드
	static void judge() {
		
		// 규영이 점수
		int score = 0;
		// 원소 크기 비교
		for (int i=0; i<9; i++) {
			// 규영이가 클 때 점수 +
			if(kyu[i] > inn[i])
				score += kyu[i] + inn[i];
		}
		// 규영이 점수가 총합의 절반보다 크면 승리
		if (score > SUM/2)
			win++;
	}

}
