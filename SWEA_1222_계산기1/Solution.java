package SWEA_1222_계산기1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// stack List===================================================
	static List<Character> stack;
	
	// 메인 메소드=====================================================
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case=1; test_case<=10; test_case++) {
			sc.nextInt();
			String oneLine = sc.next();
			
			System.out.println("#" + test_case + " " + calcultator(oneLine));
		}
		
	}
	// 중위 표기식 => 계산==============================================
	static int calcultator(String infix) {
		String postfix = toPostfix(infix);
		return eval(postfix);
	}
	
	// 중위 표기식 => 후위 표기식=========================================
	static String toPostfix(String infix) {
		stack = new ArrayList<>();
		
		String postfix = "";
		
		for (int i=0; i<infix.length(); i++) {
			char c = infix.charAt(i);
			
			// 피연산자는 push 
			if (c>='0' && c<='9') 
				push(c);
			// `+`는 피연산자와 `+` pop 그리고 본인 push
			else {
				postfix += pop();
				if (peek()=='+')
					postfix += pop();
				push(c);
			}			
		}
		// 다 끝나면 모두 pop
		while (!isEmpty()) {
			postfix += pop();
		}
		return postfix;
	}
	
	// 후위 표기식 => 계산==============================================
	static int eval(String postfix) {
		
		stack = new ArrayList<>();
		
		for (int i=0; i<postfix.length(); i++) {
			char c = postfix.charAt(i);
			// 피연산자는 push
			if (c>='0' && c<='9')
				push(c);
			// + 나오면 스택에서 두개 pop해서 계산 후 결과 push
			else {
				int num2 = pop() - '0';
				int num1 = pop() - '0';
				char result = (char) (num1 + num2 +'0');
				push(result);
			}
		}
		// 스택에 남아있는 결과 return
		return ((int) (pop() - '0'));
	}
	
	
	// stack push====================================================
	static void push(char element) {
		stack.add(element);
	}
	// stack pop=====================================================
	static char pop() {
		if (isEmpty())
			return 0;
		char element = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return element;
	}
	// stack peek===================================================
	static char peek() {
		if (isEmpty())
			return 0;
		return stack.get(stack.size()-1);
	}
	// stack isEmpty=================================================
	static boolean isEmpty() {
		return stack.size()==0;
	}
}