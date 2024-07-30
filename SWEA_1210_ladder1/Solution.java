package SWEA_1210_ladder1;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // test case 번호 받기
            sc.nextInt();
			// 변수 설정 및 입력=======================================
			int startPoint = 0;
            int endPoint = 0;
			int[][] ladders = new int[102][102];
			for (int i=1; i<=100; i++) {
				for (int j=1; j<=100; j++) {
					ladders[i][j] = sc.nextInt();
				}
			}
            // 도착점 찾기============================================
			for (int j=1; j<=100; j++) {
				if (ladders[100][j]==2) {
					endPoint = j;
					break;
				}
			}
            // 올라가기==============================================
			int col = endPoint;
            for (int i=100; i>=1; i--) {
                // 왼쪽으로 길이 있다면 위쪽 길이 나올 때까지 왼쪽으로 이동 
				if (ladders[i][col-1]==1) {
                    col--;
					while (ladders[i-1][col]!=1) {
						col--;
					}
				}
				// 오른쪽으로 길이 있다면 위쪽 길이 나올 때까지 오른쪽으로 이동 
				else if (ladders[i][col+1]==1) {
                    col++;
					while (ladders[i+1][col]!=1) {
						col++;
					}
				}
			}
            startPoint = col;
			// 출력==================================================
			System.out.println("#" + test_case + " " + (startPoint-1));
		}
	}
}