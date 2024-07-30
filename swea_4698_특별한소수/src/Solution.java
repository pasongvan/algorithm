// 2번째 시도

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 설정 및 입력===========================================
		int D = sc.nextInt();
		int A = sc.nextInt();
		if (A==1) // 1은 소수가 될 수 없으므로 2부터 시작 
			A++;
		int B = sc.nextInt();
		int cnt = 0;
		
		// 특별한 소수 찾기============================================
		for (int i=A; i<=B; i++) {
			// 소수인지 검사
			cnt++;
			for (int j=2; j<i; j++) {
				if (i%j == 0) {
					
					break;
				}
			}
		}

	}

}
