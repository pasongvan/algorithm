import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 10크기의 1차원 배열 선언
            int[] numbers = new int[10];
            
            // 입력
            for (int i=0; i<10; i++) {
                numbers[i] = sc.nextInt();
            }
            // 정렬
            Arrays.sort(numbers);
            // 출력
            System.out.println("#" + test_case + " " + numbers[9]);
		}
	}
}