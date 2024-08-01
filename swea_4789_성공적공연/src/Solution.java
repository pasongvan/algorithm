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
			// 변수 및 입력=========================================
			String oneLine = sc.next();
			int[] shy = new int[oneLine.length()];
			for (int i=0; i<oneLine.length(); i++) {
				shy[i] = Integer.parseInt(oneLine.substring(i, i+1));
			}
			int[] cumSum = new int[oneLine.length()];
			cumSum[0] = shy[0];
			for (int i=1; i<oneLine.length(); i++) {
				cumSum[i] += (cumSum[i-1] + shy[i]); 
			}
			int worker = 0;
			
			// 필요 고용인원 계산=====================================
			for (int i=1; i<oneLine.length(); i++) {
				if (shy[i]!=0 && (cumSum[i-1] + worker) < i) {
					worker += (i - cumSum[i-1] - worker);
				}
			}
			// 출력================================================
			System.out.println("#" + test_case + " " + worker);
		}
	}
}