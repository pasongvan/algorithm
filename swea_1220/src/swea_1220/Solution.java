package swea_1220;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int previous = 0;
            int[][] table = new int[100][100];
            int tmpCnt = 0; // 열 별 임시카운트
            int staleCnt = 0; // 교착상태 카운트
            
            // 입력=========================================
            int N = sc.nextInt();
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    table[i][j] = sc.nextInt();
                }
            }
            // 계산=========================================
            for (int j=0; j<N; j++) {
                tmpCnt = 0; // 임시카운트 초기화
                previous = 0; // previous 초기화
                for (int i=0; i<N; i++) { // 열 별로 세기
                    // N극일 때
                    if (table[i][j]==1) {
                        previous = 1; // N극이었음을 저장
                        // 1. N극이 처음 나오면 임시카운트+1
                        if (tmpCnt==0) 
                            tmpCnt++;
                        // 3-1. N극이 다시 처음 나오면 임시카운트 1로 저장, 교착카운트+1
                        else if (tmpCnt==2) {
                    	tmpCnt = 1;
                        staleCnt++;
                    	}
                    // S극일 때
                    } else if (table[i][j]==2) {
                        previous = 2; // S극이었음을 저장
                        // 2. S극이고 임시카운트 1일 때 임시카운트+1
                        if (tmpCnt==1)
                            tmpCnt++;
                    }
                }
                // 3-2 임시카운트 2이고 previous가 S극인 상태로 끝났다면 교착카운트+1
                if (tmpCnt==2 && previous==2)
                    staleCnt++;
            }
            System.out.println("#"+test_case+" "+staleCnt);
		}
	}
}