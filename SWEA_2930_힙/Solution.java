package SWEA_2930_힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// N 입력
			int N = sc.nextInt();
			
			// 힙 생성
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			
			// N회 반복하며 출력
			System.out.print("#" + test_case + " ");			
			for (int iter=0; iter<N; iter++) {
				// 명령 입력
				int cmd = sc.nextInt();
				
				// 연산 1
				if (cmd == 1) {
					int item = sc.nextInt();
					heap.add(item);
				}
				// 연산 2
				else {
					if (heap.isEmpty())
						System.out.print(-1 + " ");
					else {
						int pollOut = heap.poll();
						System.out.print(pollOut + " ");
					}
				}
			}
			System.out.println();
		}	
	}
}