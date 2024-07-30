package SWEA_1954_달팽이숫자;

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
            // 변수 설정 및 입력=======================================
            int N = sc.nextInt();
            int [][] snail = new int[N][N];
            int row = 0;
            int col = -1;
            int number = 1;
            
            // 달팽이 숫자 배열에 저장===================================
            quit:
            while (true) {
                for (int i=N; i>0; i-=2) {
                    // 오른쪽으로 i개 저장
                    for (int j=1; j<=i; j++) {
                        snail[row][col+j] = number;
                        number++;
                        if (number>N*N) // 모두 저장했으면 종료
                            break quit;
                    }
                    col += i;
                    // 아래쪽으로 i-1개 저장
                    for (int j=1; j<=i-1; j++) {
                        snail[row+j][col] = number;
                        number++;
                    }
                    row += i - 1;
                    // 왼쪽으로 i-1개 저장
                    for (int j=1; j<=i-1; j++) {
                        snail[row][col-j] = number;
                        number++;
                        if (number>N*N) // 모두 저장했으면 종료
                            break quit;
                    }
                    col -= i - 1;
                    // 위쪽으로 i-2개 저장
                    for (int j=1; j<=i-2; j++) {
                        snail[row-j][col] = number;
                        number++;
                    }
                    row -= i - 2;
                }
            }
            // 출력================================================
            System.out.println("#" + test_case);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
		}
    }
}