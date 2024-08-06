package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + test_case + " " + power(N, M));
		}
	}
	
	// 거듭제곱 재귀 메소드
	static int power(int N, int M) {
		// 기저 조건
		if (M==1)
			return N;
		// 재귀
		return N * power(N, M-1);
	}
}