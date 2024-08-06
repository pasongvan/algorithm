package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	// 우선순위 맵
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
		map.put('(', 0);
	}
	
	// main method=============================================================== 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case=1; test_case<=10; test_case++) {
			sc.nextInt();
			String oneLine = sc.next();
			System.out.println("#" + test_case + " " + calc(oneLine));
		}
	}
	
	// 통합 계산 메소드==============================================================
	static int calc(String infix) {
		return eval(toPostfix(infix));
	}
	
	// 후위 계산식 변환 메소드==========================================================
	static String toPostfix(String infix) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		
		for (int i=0; i<infix.length(); i++) {
			char c = infix.charAt(i);
			// 1. 숫자는 push
			if (c>='0' && c<='9')
				stack.push(c);
			// 2. 여는 괄호도 push
			else if (c == '(')
				stack.push(c);
			// 3. 닫는 괄호는 여는 괄호가 나올 때까지 pop, 여는 괄호는 출력x
			else if (c == ')') {
				char top = stack.pop();
				while(top != '(') {
					postfix += top;
					top = stack.pop();
				}
			}
			// 4. 연산자는 top에 연산 우선순위 낮은 연산자가 나올 때까지 pop, 본인은 push
			else {
				// top이 비어있지 않고, 숫자이거나, 우선순위가 높거나 같은 연산자일 때까지
				while (!stack.isEmpty() && ((stack.peek()>='0' && stack.peek()<='9') || (map.get(stack.peek()) >= map.get(c)))) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}
		// 5. 다 끝나면 모두 pop (괄호 제외)
		while(!stack.isEmpty() && stack.peek()!='(') {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	// 후위 계산식 계산 메소드=====================================================
	static int eval(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i=0; i<postfix.length(); i++) {
			char c = postfix.charAt(i);
			// 1. 숫자 push
			if (c>='0' && c<='9')
				stack.push((int) (c - '0'));
			// 2. 연산자 나오면
			else {
				// 숫자 두개 pop
				int num2 = stack.pop();
				int num1 = stack.pop();
				// 더하기
				if (c=='+') 
					stack.push(num1 + num2);
				// 곱하기
				else if (c=='*') 
					stack.push(num1 * num2);
			}
		}
		// 3. 다 끝나면 계산 결과 push
		return stack.pop();
	}
}