package SWEA_3499_퍼펙트셔플;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 변수 및 입력
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			int len = sc.nextInt();
			
			// 짝수, 홀수 일 때 나누는 지점 지정
			int startQ2;
			if (len%2 == 0)
				startQ2 = len/2;
			else
				startQ2 = len/2 + 1;
			
			// 큐1에 앞 절반 담기
			for (int i=0; i<startQ2; i++) {
				String element = sc.next();
				queue1.add(element);
			}
			
			// 큐2에 뒤 절반 담기
			for (int i=startQ2; i<len; i++) {
				String element = sc.next();
				queue2.add(element);
			}
			
			// 번갈아가면서 출력
			System.out.print("#" + test_case + " ");
			for (int i=0; i<len; i++) {
				if (i%2==0) 
					System.out.print(queue1.poll() + " ");
				else 
					System.out.print(queue2.poll() + " ");
			}
			System.out.println();
		}
	}
}