package SWEA_1225_암호생성기;

import java.util.Scanner;

public class Solution {
	
	// 큐
	static int[] queue = new int[8];
	static int rear = -1;
	static int[] cycle = {1, 2, 3, 4, 5};
	static int cycleIdx = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			
			// 테스트 케이스 번호 입력
			int testCase = sc.nextInt();
			
			// 초기 값 입력
			for (int i=0; i<8; i++) {
				int item = sc.nextInt();
				offer(item);
			}
			
			// 사이클 인덱스 초기화
			cycleIdx = 0;
			
			// Qpeek - cycle이 0보다 클 때까지 계산 반복
			if ((Qpeek() - cycle[cycleIdx]) > 0) {
				while ((Qpeek() - cycle[cycleIdx]) > 0) {
					offer(poll() - cycle[cycleIdx]);
					cycleIdx = (cycleIdx + 1) % 5;
				}
			}
			
			// Qpeek - cycle이 0보다 작거나 같으면 poll, 0 offer
			poll();
			offer(0);
			
			// 출력
			System.out.print("#" + testCase + " ");
			for (int i=0; i<8; i++) {
				System.out.print(poll() + " ");
			}
			System.out.println();
		}
	}

	// offer
	static void offer(int item) {
		if (isFull()) {
			System.out.println("꽉 참");
			return;
		}
		queue[++rear] = item;
	}
	
	// poll
	static int poll() {
		// 비어있을 때
		if (isEmpty()) {
			System.out.println("텅 빔");
			return -9999;
		}
		// 반환 값 저장
		int pollOut = queue[0];
		// 한칸씩 당김
		for (int i=0; i<rear; i++) {
			queue[i] = queue[i+1];
		}
		// rear 값 조정
		rear--;
		return pollOut;
	}
	
	// Qpeek
	static int Qpeek() {
		// 비어있을 때
		if (isEmpty()) {
			System.out.println("텅 빔");
			return -9999;
		}
		return queue[0];
	}
	
	// isEmpty
	static boolean isEmpty() {
		return rear == -1;
	}
	
	//isFull
	static boolean isFull() {
		return rear == queue.length-1;
	}
}