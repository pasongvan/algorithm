package SWEA_1215_회문1;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // 변수 설정 및 입력 =================================
            int N = sc.nextInt();
            String[][] board = new String[8][8];
            for (int i=0; i<8; i++) {
                String oneLine = sc.next();
                board[i] = oneLine.split("");
            }
            int cnt = 0;
            // 가로 검사========================================
            for (int r=0; r<8; r++) {
                for (int c=0; c<=8-N; c++) {
                    for (int i=0; i<N-2; i++) {
                        if ((!(board[r][c+i].equals(board[r][c+N-1-i])))) {
                            break;
                        }
                        if (i == N-3)
                            cnt++;
                    }
                }
            }
            // 세로 검사===========================================
            for (int r=0; r<=8-N; r++) {
                for (int c=0; c<8; c++) {
                    for (int i=0; i<N-2; i++) {
                        if ((!(board[r+i][c].equals(board[r+N-1-i][c])))) {
                            break;
                        }
                        if (i == N-3)
                            cnt++;
                    }
                }
            }
            // 출력=============================================
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}