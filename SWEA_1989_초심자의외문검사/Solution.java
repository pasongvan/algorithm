package SWEA_1989_초심자의외문검사;

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
			// 변수 설정 및 입력==================================
            String word = sc.next();
            String[] letters = word.split("");
            int len = letters.length;
            boolean result = true;
            
            // 회문 검사========================================
            for (int i=0; i<len/2; i++) {
                if (!(letters[i].equals(letters[len-1-i]))) {
                    result = false;
                    break;
                }
            }
            // 출력============================================
            if (result) {
                System.out.println("#"+test_case+" "+1);
            }
            else {
                System.out.println("#"+test_case+" "+0);
            }
		}
	}
}