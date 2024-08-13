package SWEA_1230_암호문3; 

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static List<Integer> list;
	
	public static void main(String[] args) {
		for (int test_case=1; test_case<=10; test_case++) {
			
			// 입력
			int N = sc.nextInt();
			list = new LinkedList<>();
			for (int i=0; i<N; i++) {
				int num = sc.nextInt();
				list.add(num);
			}
			
			// 명령 개수 입력
			int numCommand = sc.nextInt();
			
			// 명령 개수만큼 반복
			for (int command=0; command<numCommand; command++) {
				String cmd = sc.next();
				
				// 삽일 명령일 때
				if (cmd.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					insert(x, y);
				}
				// 삭제 명령일 때
				else if (cmd.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					delete(x, y);
				}
				// 추가 명령일 때
				else {
					int y = sc.nextInt();
					add(y);
				}
			}
			// 첫 10개 출력
			System.out.print("#" + test_case + " ");
			for (int i=0; i<10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
	// 삽입 메소드
	static void insert(int x, int y) {
		for (int i=0; i<y; i++) {
			int number = sc.nextInt();
			list.add(x, number);
			x++;
		}
	}
	
	// 삭제 메소드
	static void delete(int x, int y) {
		for (int i=0; i<y; i++) {
			list.remove(x);
		}
	}
	
	// 추가 메소드
	static void add(int y) {
		for (int i=0; i<y; i++) {
			int number = sc.nextInt();
			list.add(number);
		}
	}
}