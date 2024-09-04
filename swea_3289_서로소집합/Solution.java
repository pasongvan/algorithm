package swea_3289_서로소집합;

import java.util.Scanner;

public class Solution {
	
	static int[] rep;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			rep = new int[N+1];
			
			// 자기 자신을 대표로 하는 집합 생성
			for (int i=0; i<N; i++) {
				rep[i] = i;
			}
			
			// 테스트 케이스 번호 출력
			System.out.print("#" + tc + " ");
			
			// 명령 M회 반복
			for (int i=1; i<=M; i++) {
				int command = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				// 합집합
				if (command == 0) {
					union(a, b);
				}
				
				// 포함 유무 출력
				else {
					if (findSet(a) == findSet(b))
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
			
			System.out.println();
		}
	}
	
	static int findSet(int x) {
		if (rep[x] != x)
			rep[x] = findSet(rep[x]);
		return rep[x];
	}
	
	static void union(int x, int y) {
		rep[findSet(y)] = findSet(x);
	}

}
