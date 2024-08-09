
import java.util.Scanner;

public class 오셀로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 오셀로 판 배열
			int[][] board = new int[N+1][N+1];
			
			// 초기 상태 돌 놓기
			board[N/2][N/2] = 2;
			board[N/2+1][N/2+1] = 2;
			board[N/2+1][N/2] = 1;
			board[N/2][N/2+1] = 1;
			
			// 여덟방향 델타 배열 (위부터 시계)
			int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
			int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
			int didx = 0;
			
			// 돌 입력 값 만큼 반복
			for (int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int player = sc.nextInt();
				
				// 돌 두기
				board[x][y] = player;
				
				// 주어진 좌표에 대해 팔방 탐색
				for (didx=0; didx<8; didx++) {
										
					// 해당 방향으로 인접해있는 돌이 상대편 돌일 때 (+인덱스 범위 안)
					int newX = x + dx[didx];
					int newY = y + dy[didx];
					if(newX>=1 && newX<=N && newY>=1 && newY<=N && board[newX][newY]==3-player) {
												
						// 내 돌을 찾을 때까지 전진
						while(newX>=1 && newX<=N && newY>=1 && newY<=N && board[newX][newY]!=0) {
							// 내 돌을 찾으면
							if (board[newX][newY]==player) {
								
								// 그 사이 돌들 다 내 돌로 바꿈
								while(newX!=x || newY!=y) {
									newX -= dx[didx];
									newY -= dy[didx];
									board[newX][newY] = player;
									
								}
								break;
							}
							// 못 찾으면 전진
							newX += dx[didx];
							newY += dy[didx];
						}
					}
				}
				
			}
			// 흑돌 개수 백돌 개수 세기
			int black = 0;
			int white = 0;
			for (int x=1; x<=N; x++) {
				for (int y=1; y<=N; y++) {
					// 흑돌 카운트
					if (board[x][y] == 1)
						black++;
					else if (board[x][y] ==2)
						white++;
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + black + " " + white);
		}
	}
}
// 0: 빈칸, 1: 흑돌, 2: 백돌
// 1. (N+1)x(N+1) 이차원 배열 생성 - 0인덱스 사용x
// 2. [N/2][N/2], [N/2+1][N/2+1]에 백돌
// 3. [N/2+1][N/2], [N/2][N/2+1]에 흑돌

// 여덟 방향 델타배열 설정
// 4. 델타배열 방향으로 쭉 가서 본인과 같은 돌이 있으면 그 사이 돌들 다 바꿔줌


