package swea_1289_원재의메모리복구;

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
			// 입력 및 변수
            String stringNum = sc.next();
            String[] numArray = stringNum.split("");
            int previous = 0;
            int cnt = 0;
            
            // 계산
            for (int i=0; i<stringNum.length(); i++) {
                // 1 나오고 previous==0이면 => previous=1, cnt++
                if (numArray[i].equals("1") && previous==0) {
                    previous=1;
                    cnt++;
                }
                // 0 나오고 previous==1이면 => previous=0, cnt++
                else if (numArray[i].equals("0") && previous==1) {
                    previous=0;
                    cnt++;
                }
            }
            
            // 출력
            System.out.println("#"+test_case+" "+cnt);
		}
	}
}