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
			int N = sc.nextInt();
            int sum = 0;
            String oneLine;
            int[][] farm = new int[N][N];
            for (int i=0; i<N; i++) {
                oneLine = sc.next();
                for (int j=0; j<N; j++) {
                    farm[i][j] = (int) oneLine.charAt(j) - 48;
                }
            }
            // 윗칸
            for (int i=0; i<=N/2; i++) {
                for (int j=-i; j<=i; j++) {
                    sum += farm[i][N/2 + j];
                }
            }
            // 아랫칸
            for (int i=1; i<=N/2; i++) {
                for (int j=i; j<=N-1-i; j++) {
                    sum += farm[N/2+i][j];
                }
            }
            // 출력
            System.out.println("#" + test_case + " " + sum);
		}
	}
}