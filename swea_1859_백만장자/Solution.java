package SWEA_1859_백만장자프로젝트;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			
			// 스택 선언
			Stack<Integer> stack1 = new Stack<>(); // 최근이 top으로 오는 스택
			Stack<Integer> stack2 = new Stack<>(); // 과거가 top으로 오는 스택
			
			// 수익 합
			long sum = 0;
			
			// 입력
			int N = sc.nextInt();
			for (int i=0; i<N; i++) {
				int item = sc.nextInt();
				stack1.push(item);
			}
			
			// 스택1에서 스택2로 저장
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			
			// 두 스택이 모두 빌 때까지 반복
			while (!stack1.isEmpty() || !stack2.isEmpty()) {
				int max = 0;
				
				// max 값을 갱신하며 스택 1에 넣음
				while(!stack2.isEmpty()) {
					// max 갱신
					if (max < stack2.peek())
					max = stack2.peek();
					// stack2에서 스택1으로 저장
					stack1.push(stack2.pop());
				}
				
				// max 값이 스택1의 top이 될 때까지 스택2에 넣음
				while (stack1.peek() != max) {
					stack2.push(stack1.pop());
				}
				
				// 스택1 모든 아이템 pop하면서 max값과 차이를 sum에 저장
				while (!stack1.isEmpty()) {
					sum += max - stack1.pop();
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + sum);
		}
	}
}