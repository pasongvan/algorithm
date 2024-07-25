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
			// 변수 설정 및 입력
            int N = sc.nextInt();
            
            // 테스트케이스 출력
            System.out.println("#"+test_case);
            
            // 맨 위 줄 출력
            System.out.println(1);
            
            // 2번째 줄 이하 출력
            for (int i=1; i<N; i++) {
                System.out.print(1 + " ");
                for (int j=0; j<i-1; j++) {
                    System.out.print(i + " ");
                }
                System.out.println(1);
            }
		}
	}
}