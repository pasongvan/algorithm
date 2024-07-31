package SWEA_1216_회문2;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// test-case 번호 입력
            int testCase = sc.nextInt();
			// 변수 설정 및 입력=====================================
            int maxPel = 1;
            String[][] board = new String[100][100];
            for (int i=0; i<100; i++) {
                String oneLine = sc.next();
                board[i] = oneLine.split("");
            }
            // 가로 검사==========================================
            // 모든 칸 검사
            for (int r=0; r<100; r++) {
                for (int c=0; c<100; c++) {
                    // 각 칸에 대해 회문인지 검사
                    quit_for:
                    for (int len=100-c; len>1; len--) { // 길게부터
                        for (int i=0; i<len/2; i++) { // 회문검사
                            if (!(board[r][c+i].equals(board[r][99-i]))) {
                                break;
                            }
                            if (i == len/2-1) { // 회문 검사를 모두 통과했다면
                                if (maxPel < len) { // 그리고 저장된 최댓값보다 크다면
                                    maxPel = len; // 최댓값 갱신
                                }
                                break quit_for; // len보다 짧은 길이는 볼 필요 없음
                            }
                        }
                    }
                }
            }
            // 세로 검사==========================================
            // 모든 칸 검사
            for (int r=0; r<100; r++) {
                for (int c=0; c<100; c++) {
                    // 각 칸에 대해 회문인지 검사
                    quit_for:
                    for (int len=100-r; len>1; len--) { // 길게부터
                        for (int i=0; i<len/2; i++) { // 회문검사
                            if (!(board[r+i][c].equals(board[99-i][c]))) {
                                break;
                            }
                            if (i == len/2-1) { // 회문 검사를 모두 통과했다면
                                if (maxPel < len) { // 그리고 저장된 최댓값보다 크다면
                                    maxPel = len; // 최댓값 갱신
                                }
                                break quit_for; // len보다 짧은 길이는 볼 필요 없음
                            }
                        }
                    }
                }
            }
            // 출력 =============================================
            System.out.println("#" + testCase + " " + maxPel);
		}
	}
}