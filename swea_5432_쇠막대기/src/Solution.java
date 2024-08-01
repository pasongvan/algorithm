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
			// 변수==================================================
			int toDivide = 0;
			int divided = 0;
			String oneLine = sc.next();
			String[] command = oneLine.split("");
			
			// 막대기 세기=============================================
			for (int i=0; i<command.length; i++) {
				// 1. `(`를 만났을 때
				if (command[i].equals("(")) {
					toDivide++;
					divided++;
				}
			// 2. `)`를 만났을 때
				else {
					toDivide--;
					// 2-1. 직전이 `(`이었을 때
					if (i>0 && command[i-1].equals("(")) {
						divided--;
						divided += toDivide;
					}
				}
			}
			//출력===================================================
			System.out.println("#" + test_case + " " + divided);
		}
	}
}