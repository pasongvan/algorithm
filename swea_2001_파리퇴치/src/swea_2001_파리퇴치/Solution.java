package swea_2001_파리퇴치;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			//입력 및 변수설정===========================================
            int maxFlies = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] board = new int[N+M-1][N+M-1];
            int tmp = 0;
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            //계산==================================================
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    tmp = 0;
                    for (int di=0; di<M; di++) {
                        for (int dj=0; dj<M; dj++) {
                            tmp += board[i+di][j+dj];
                        }
                    }
                    if (tmp > maxFlies)
                        maxFlies = tmp;
                }
            }
            // 출력==================================================
            System.out.println("#"+test_case+" "+maxFlies);
		}
	}
}