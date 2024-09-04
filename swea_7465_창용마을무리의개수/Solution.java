package swea_7465_창용마을무리의개수;

import java.util.Scanner;

public class Solution {
	
	static boolean[][] person;
	static boolean[] visit;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// N, M 입력 및 배열 선언
			N = sc.nextInt();
			int M = sc.nextInt();
			person = new boolean[N+1][N+1];
			visit = new boolean[N+1];
			
			// 인간관계 정보 저장
			for (int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				person[a][b] = true;
				person[b][a] = true;
			}
			
			// 무리 개수
			int crowd = 0;
			
			// 모든 사람 순회
			for (int i=1; i<=N; i++) {
				// 방문했으면 continue
				if (visit[i]) continue;
				
				// dfs 호출
				dfs(i);
				
				// 무리 수 +1
				crowd++;
			}
			
			// 결과 출력
			System.out.println("#" + tc + " " + crowd);
			
		}

	}
	static void dfs(int i) {
		// 방문처리
		visit[i] = true;
		
		for (int j=1; j<=N; j++) {
			// 본인은 넘기기
			if (i == j) continue;
			// 방문했거나 관계없는 사람은 넘기기
			if (!person[i][j] || visit[j]) continue;
			
			// 재귀
			dfs(j);
		}
	}

}
