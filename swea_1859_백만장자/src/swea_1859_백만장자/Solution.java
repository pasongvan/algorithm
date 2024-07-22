package swea_1859_백만장자;

// 시간 초과

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
			//변수 설정==========================================
            int days = sc.nextInt();
            int[] price = new int[days];
            int startIndex = 0;
            int maxPrice = 0;
            int maxIndex = 0;
            int profit = 0;
            
            // 입력=============================================
            for (int i=0; i<days; i++) {
                price[i] = sc.nextInt();
            }
            
            //계산==============================================
            while(startIndex<days) {
                // 최고가격 초기화
                maxPrice = 0;
                maxIndex = 0;
                // 최고 가격 찾기
                for (int i=startIndex; i<days; i++) {
                    if (maxPrice <= price[i]) {
                        maxPrice = price[i];
                        maxIndex = i;
                    }
                }
                // 최고 가격 이전 일들에 대한 이윤 구하기
                for (int i=startIndex; i<maxIndex; i++) {
                    profit += (maxPrice - price[i]);
                }
                // 다음 시작 일자 설정
                startIndex = maxIndex + 1;
            }
            // 출력================================================
            System.out.println("#"+test_case+" "+profit);
		}
	}
}