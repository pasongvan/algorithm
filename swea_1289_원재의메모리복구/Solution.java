package SWEA_1289_원재의메모리복구;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			int value = 1; // 비교 검사 값
			int count = 0; // 바꿔야하는 개수
			
			// 문자열로 받음
			String oneLine = sc.next();
			int len = oneLine.length();
			
			// 앞에부터 순회하며 검사
			for (int i=0; i<len; i++) {
				// 정수형 한자리씩 변환
				int num = oneLine.charAt(i) - '0';
				// 비교 검사 값고 같으면 카운트+1
				if (num == value) {
					count++;
					value = 1 - value; // 비교 값 0->1, 1->0
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + count);
		}
	}
}