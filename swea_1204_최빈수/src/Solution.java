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
			sc.nextInt();
			
			// 점수 별로 몇 명인지 입력
			int[] scores = new int[101];
			for (int i=0; i<1000; i++) {
				int score = sc.nextInt();
				scores[score]++;
			}
			// 최빈값 찾기
			int frq = 0;
			int idx = 0;
			for (int i=0; i<101; i++) {
				if (frq <= scores[i]) {
					frq = scores[i];
					idx = i;
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + idx);
		}
	}
}