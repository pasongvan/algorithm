package swea_1940_rc카;

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
            // 변수 설정============================================
			int numberOfCommand = sc.nextInt();
            int velocity = 0;
            int distance = 0;
            int command;
            int acc;
            
            // 계산===================================================
            for (int i=0; i<numberOfCommand; i++) {
                command = sc.nextInt(); // 명령 입력
                //가속
                if (command==1) {
                    acc = sc.nextInt();
                    velocity += acc;
                }
                //감속
                else if (command==2) {
                    acc = sc.nextInt();
                    velocity -= acc;
                }
                // 속도 음수면 0으로
                if (velocity<0)
                    velocity = 0;
                // 이동거리 더해주기
                distance += velocity;
            }
            // 출력=============================================
            System.out.println("#"+test_case+" "+distance);
		}
	}
}