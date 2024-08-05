package SWEA_1218_괄호짝짓기;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	// 스택 선언
	static List<String> openBracket;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			// 변수 선언========================================
			openBracket = new ArrayList<>();
			int valid = 1; // 유효성 여부
			int len = sc.nextInt();
			String oneLine = sc.next();
			
			// 괄호 검사========================================
			for (int i=0; i<len; i++) {
				String blacket = oneLine.substring(i, i+1);
				
				// 1. 여는 괄호인 경우
				if (blacket.equals("(") || blacket.equals("{") || blacket.equals("[") || blacket.equals("<"))
					push(blacket);
				
				// 2. 닫는 괄호인 경우
				// 스택이 비어있으면 유효x
				else if (isEmpty()) {
					valid = 0;
					break;
				}
				else {
					// 닫는 괄호와 스택 top 종류가 다르면 유효x
					String top = pop();
					if ((top.equals("(") && !blacket.equals(")")) || (top.equals("{") && !blacket.equals("}")) || (top.equals("[") && !blacket.equals("]")) || (top.equals("<") && !blacket.equals(">"))) {
						valid = 0;
						break;
					}
				}
			}
			// 괄호 검사가 끝났는데도 스택이 비어있지 않다면 유효x
			if (!isEmpty())
				valid = 0;
			
			// 출력============================================
			System.out.println("#" + test_case + " " + valid);
		}
	}
	// push method============================================
	static void push(String blacket) {
		openBracket.add(blacket);
	}
	
	// pop method=============================================
	static String pop() {
		String popOut = openBracket.get(openBracket.size()-1);
		openBracket.remove(openBracket.size()-1);
		return popOut;
	}
	
	// peek method============================================
	static String peek() {
		return openBracket.get(openBracket.size()-1);
	}
	
	// isEmpty method=========================================
	static boolean isEmpty() {
		return openBracket.size()==0;
	}
	
}