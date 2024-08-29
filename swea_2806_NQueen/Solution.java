package swea_2806_NQueen;

import java.util.Scanner;

public class Solution {
	
	// static 변수
	static boolean[][] board;
	static int N;
	static int cases;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// N 입력
			N = sc.nextInt();
			
			// 변수 초기화
			board = new boolean[N][N];
			cases = 0;
			
			// method 호출
			method(0);
			
			// 경우의 수 출력
			System.out.println("#" + tc + " " + cases);
		}

	}
	
	// 경우의 수 계산 메소드
	static void method(int row) {
		
		// 기저조건: 모든 퀸을 위치시켰으면 경우의 수 +1
		if (row == N) {
			cases++;
			return;
		}
		
		// 재귀부분
		for (int col=0; col<N; col++) {
			// 열 방향, 대각선 방향으로 겹치는 퀸이 있다면 넘김
			if (!ableCol(col) || !ableCross(row, col)) continue;
			
			// 해당 칸에 퀸 위치 시킴
			board[row][col] = true;
			// 재귀
			method(row+1);
			// 퀸 원상복구
			board[row][col] = false;
		}
	}
	
	// 열 방향 체크 메소드
	static boolean ableCol(int col) {
		for (int i=0; i<N; i++) {
			if (board[i][col]) // 퀸이 놓인 행이 있다면 false 리턴
				return false;
		}
		return true; // 반복문 통과 시 true 리턴
	}
	
	// 대각선 방향 체크 메소드
	static boolean ableCross(int row, int col) {
		
		// 우하향 대각선 체크
		for (int i=1; i<N-row; i++) {
			// 인덱스 벗어나면 break
			if (col+i >= N) break;
			// 퀸이 발견되면 false return
			if (board[row+i][col+i]) return false;
		}
		
		// 좌하향 대각선 체크
		for (int i=1; i<N-row; i++) {
			// 인덱스 벗어나면 break
			if (col-i < 0) break;
			// 퀸이 발견되면 false return
			if (board[row+i][col-i]) return false;
		}
		
		// 우상향 대각선 체크
		for (int i=1; i<=row; i++) {
			// 인덱스 벗어나면 break
			if (col+i >= N) break;
			// 퀸이 발견되면 false return
			if (board[row-i][col+i]) return false;
		}
		
		// 좌상향 대각선 체크
		for (int i=1; i<=row; i++) {
			// 인덱스 벗어나면 break
			if (col-i < 0) break;
			// 퀸이 발견되면 false return
			if (board[row-i][col-i]) return false;
		}
		
		// 모든 방향에 대해 통과했다면 true 반환
		return true;
	}
}










