package swea_1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {

	static int H, W;
	static char[][] field;
	static int row, col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// 입력
			H = sc.nextInt();
			W = sc.nextInt();
			field = new char[H][W];
			for (int i=0; i<H; i++) {
				String oneLine = sc.next();
					field[i] = oneLine.toCharArray();
			}
			
			// 전차 출발 위치 찾기
			quit:
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (field[i][j]=='^' || field[i][j]=='v' || field[i][j]=='<' || field[i][j]=='>') {
						row = i;
						col = j;
						break quit;
					}
				}
			}
			
			// 명령 개수만큼 반복
			int num_command = sc.nextInt();
			String oneLineCommand = sc.next(); 
			for (int iter=0; iter<num_command; iter++) {
				char command = oneLineCommand.charAt(iter);
				
				// 명령별 호출
				switch (command) {
				case 'U': 
					up();
					break;
				case 'D': 
					down();
					break;
				case 'L': 
					left();
					break;
				case 'R': 
					right();
					break;
				case 'S': 
					shoot();
				}
			}
			
			// 결과 출력
			System.out.print("#" + tc + " ");
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}
	// up method
	static void up() {
		// 위가 평지라면 간다
		if (row-1>=0 && field[row-1][col]=='.') {
			field[row][col] = '.';
			field[--row][col] = '^';
		}
		// 아니면 방향만 바꾼다
		else {
			field[row][col] = '^';
		}
	}
	
	// down method
	static void down() {
		// 아래가 평지라면 간다
		if (row+1<=H-1 && field[row+1][col]=='.') {
			field[row][col] = '.';
			field[++row][col] = 'v';
		}
		// 아니면 방향만 바꾼다
		else {
			field[row][col] = 'v';
		}
	}
	
	// left method
	static void left() {
		// 왼쪽이 평지라면 간다
		if (col-1>=0 && field[row][col-1]=='.') {
			field[row][col] = '.';
			field[row][--col] = '<';
		}
		// 아니면 방향만 바꾼다
		else {
			field[row][col] = '<';
		}
	}
	
	// right method
	static void right() {
		// 오른쪽이 평지라면 간다
		if (col+1<=W-1 && field[row][col+1]=='.') {
			field[row][col] = '.';
			field[row][++col] = '>';
		}
		// 아니면 방향만 바꾼다
		else {
			field[row][col] = '>';
		}
	}
	
	// shoot method
	static void shoot() {
		// 델타 배열, 상하좌우 순
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int didx = 0;
		
		// 방향 정해주기
		switch (field[row][col]) {
		case '^': didx = 0; break;
		case 'v': didx = 1; break;
		case '<': didx = 2; break;
		case '>': didx = 3; break;
		}
		
		// 포탄 인덱스
		int row_bomb = row + dr[didx];
		int col_bomb = col + dc[didx];

		// 포탄 발사
		while (row_bomb>=0 && row_bomb<H && col_bomb>=0 && col_bomb<W) {
			
			// 벽돌 벽을 만나면 벽 파괴 후 반복문 종료
			if (field[row_bomb][col_bomb]=='*') {
				field[row_bomb][col_bomb] = '.';
				break;
			}
			// 강철 벽을 만나면 반복문 종료
			else if (field[row_bomb][col_bomb]=='#') break;
			
			// 포탄 인덱스 변경
			row_bomb += dr[didx];
			col_bomb += dc[didx];
		}
		
	}

}





