package SWEA_1228_암호문1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			
			// 입력
			int N = sc.nextInt();
			List<Integer> list = new LinkedList<>();
			for (int i=0; i<N; i++) {
				int num = sc.nextInt();
				list.add(num);
			}
			int numCommand = sc.nextInt();
			
			// 명령 횟수만큼 반복
			for (int command=0; command<numCommand; command++) {
				// | 날리기
				sc.next();
				
				// x, y 입력
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				// x 뒤로 y개 삽입
				for (int i=0; i<y; i++) {
					int number = sc.nextInt();
					list.add(x, number);
					x++;
				}
			}
			// 처음 10개 출력
			System.out.println("#" + test_case + " ");
			for (int i=0; i<10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}