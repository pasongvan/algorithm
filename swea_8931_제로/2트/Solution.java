package SWEA_8931_제로;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	// 변수 선언===============================================
	static List<Integer> stack;
	static int top;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수
		// 테스트 케이스마다 실행=====================================
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 영수증 적기=========================================
			stack = new ArrayList<>();
			int K = sc.nextInt(); // 영수증 개수
			// 영수증 개수만큼 반복 입력
			for (int i=0; i<K; i++) {
				int receipt = sc.nextInt(); // 영수증 입력
				// 영수증이 0이 아닌 경우
				if (receipt != 0) {
					push(receipt);
				}
				// 영수증이 0인 경우
				else {
					pop();
				}
			}
			// 장부 합 구하기=======================================
			int sum = 0;
			for (int i=0; i<stack.size(); i++) {
				sum += stack.get(i);
			}
			// 결과 출력=========================================
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
	// push method=============================================
	static void push(int receipt) {
		stack.add(receipt);
		top = stack.size() - 1;
	}
	
	// pop method=================================================
	static int pop() {
		int popOut = stack.get(top);
		stack.remove(top);
		top = stack.size() - 1;
		return popOut;
	}
}