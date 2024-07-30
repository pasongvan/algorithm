package SWEA_2001_파리퇴치;

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
			//변수 설정 및 입력==================================
            int N = sc.nextInt();
            int M = sc.nextInt();
            int maxFlies = 0;
            int partSum;
            int[][] flies = new int[N+M][N+M]; // 오른쪽, 아래 테두리는 파리 0마리
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    flies[i][j] = sc.nextInt();
                }
            }
            // 계산==========================================
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    partSum = 0; // 초기화
                    //MxM
                    for (int ii=0; ii<M; ii++) {
                        for (int jj=0; jj<M; jj++) {
                            partSum += flies[i+ii][j+jj];
                        }
                    }
                    if (maxFlies < partSum)
                        maxFlies = partSum;
                }
            }
            // 출력=========================================
            System.out.println("#" + test_case + " " + maxFlies);
		}
	}
}