package swea_1984_중간평균;

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
			//입력 및 변수 설정==========================================
            int[] numbers = new int[10];
            int maxNum = 0;
            int minNum = 10000;
            int sumNums = 0;
            int cntNums = 0;
            double result;
            
            for (int i=0; i<10; i++) {
                numbers[i] = sc.nextInt();
                if (maxNum < numbers[i])
                    maxNum = numbers[i]; // 최댓값 저장
                if (minNum > numbers[i])
                    minNum = numbers[i]; // 최솟값 저장
            }
            // 계산==================================================
            for (int i=0; i<10; i++) {
                if (minNum < numbers[i] && numbers[i] < maxNum) {
                    sumNums += numbers[i];
                    cntNums++;
                }
            }
            result = (double) sumNums / (double) cntNums;
            // 출력==================================================
            if (result - (int) result >= 0.5)
                System.out.println("#"+test_case+" "+(int) (result + 1));
            else
                System.out.println("#"+test_case+" "+(int) result);
		}
	}
}