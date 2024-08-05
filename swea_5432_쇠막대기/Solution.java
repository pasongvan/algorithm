package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	// 스택 리스트 선언==========================================================
	static List<Integer> stick; // 막대기 개수 스택
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 테스트 케이스========================================================
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 변수 설정======================================================
			stick = new ArrayList<>(); // 스택 초기화
			int dividedStick = 0; // 쪼개진 막대기 개수
			String oneLine = sc.next();
			
			// 막대기 쪼개기 계산===============================================
			for (int i=0; i<oneLine.length(); i++) {
				// 여는 괄호가 나왔을 때
				if (oneLine.substring(i, i+1).equals("(")) {
					push(); // 막대기 +1
				}
				// 닫는 괄호가 나왔을 때
				else {
					pop(); // 막대기 -1
					// 직전 괄호가 여는 괄호였을 때 (레이저 빔)
					if (i>0 && oneLine.substring(i-1, i).equals("(")) {
						dividedStick += size();
					}
					// 직전 괄호가 닫는 괄호였을 때
					else {
						dividedStick++; // 쪼개진 막대기 +1
					}
				}
			}
			// 출력===========================================================
			System.out.println("#" + test_case + " " + dividedStick);
		}
	}
	// push==================================================================
	static void push() { // 스택에 들어갈 원소는 1로 고정 => 매개변수 없음 
		stick.add(1);
	}
	
	// pop()==================================================================
	static void pop() { // 이 문제에서는 pop의 리턴 값이 필요없으므로 void로 선언
		stick.remove(stick.size()-1);
	}
	
	// size()================================================================
	static int size() {
		return stick.size();
	}
}