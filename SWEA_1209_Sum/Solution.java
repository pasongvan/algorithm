package SWEA_1209_Sum;

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
            sc.nextInt();
			//변수 설정 및 입력================================================
            int sumLine = 0;
            int maxSum = 0;
            int[][] numbers = new int[100][100];
            for (int i=0; i<100; i++) {
                for (int j=0; j<100; j++) {
                    numbers[i][j] = sc.nextInt();
                }
            }
            // 가로 검사=====================================================
            for (int i=0; i<100; i++) {
                sumLine = 0;
                for (int j=0; j<100; j++) {
                    sumLine += numbers[i][j];
                }
                if (maxSum < sumLine)
                    maxSum = sumLine;
            }
            // 세로 검사=====================================================
            for (int j=0; j<100; j++) {
                sumLine = 0;
                for (int i=0; i<100; i++) {
                    sumLine += numbers[i][j];
                }
                if (maxSum < sumLine) 
                    maxSum = sumLine;
            }
            // 오른쪽 대각선 검사===============================================
            sumLine = 0;
            for (int i=0; i<100; i++) {
                sumLine += numbers[i][i];
            }
            if (maxSum < sumLine)
                maxSum = sumLine;
            
            // 왼쪽 대각선 검사===============================================
            sumLine = 0;
            for (int i=0; i<100; i++) {
                sumLine += numbers[i][99-i];
            }
            if (maxSum < sumLine)
                maxSum = sumLine;
            
            // 출력=========================================================
            System.out.println("#" + test_case + " " +maxSum);
		}
	}
}