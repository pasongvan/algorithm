import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// N 입력
            int N = sc.nextInt();
            // N+4 크기 배열 선언
            int[] height = new int[N+4];
            // 빌딩 높이 입력 (2~N+1)
            for (int i=2; i<N+2; i++) {
                height[i] = sc.nextInt();
            }
            
            int maxHeight; // 양 옆 4개의 건물 중 가장 높은 층 수
            int sunRights = 0; // 조망권 세대수
            // 조망권 세대수 계산
            for (int i=2; i<N+2; i++) {
                maxHeight = 0;
                for (int j=-2; j<=2; j++) {
                    if (j==0)
                        continue;
                    if (maxHeight < height[i+j])
                        maxHeight = height[i+j];
                }
                if (height[i] > maxHeight) 
                    sunRights += height[i] - maxHeight;
            }
            // 출력
            System.out.println("#" + test_case + " " + sunRights);
		}
	}
}