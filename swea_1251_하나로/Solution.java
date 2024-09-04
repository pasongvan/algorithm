package swea_1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[] repIsland;
	static int[][] island;
	static long[][] edges;
	static int N; // 섬 개수
	static int M; // 모든 간선 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// 입력
			N = sc.nextInt();
			M = N*(N-1)/2;
			island = new int[N][2];
			for (int i=0; i<N; i++) {
				island[i][0] = sc.nextInt();			
			}
			for (int i=0; i<N; i++) {
				island[i][1] = sc.nextInt();
			}
			double ecoFee = sc.nextDouble();
			
			// 대표섬 배열 선언
			repIsland = new int[N];
			for (int i=0; i<N; i++) {
				repIsland[i] = i;
			}

			// 가능한 모든 간선 생성
			edges = new long[M][3];
			int idx = 0; // 간선배열 인덱스
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					edges[idx][0] = i;
					edges[idx][1] = j;
					// 두 섬간 거리 제곱
//					long disSq = (island[i][0] - island[j][0])*(island[i][0] - island[j][0]) + (island[i][1] - island[j][1])*(island[i][1] - island[j][1]);
					long disSq = (long) (Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2)); 
					// long 형의 범위를 넘어가면 그냥 max 값으로 줌
					if (disSq < 0) disSq = Long.MAX_VALUE;
					
					edges[idx++][2] = disSq;
				}
			}
			
			// 간선 거리순 정렬
			Arrays.sort(edges, (a, b) -> Long.compare(a[2], b[2]));
			
			// 크루스칼 알고리즘
			long sumDistance = 0; // 거리제곱 총합
			int pick = 0; // 택한 간선의 수
			int idx1 = 0; // 택할 간선 인덱스
			
			while (pick < N-1) {
				// 사이클 되는 것은 넘기기
				if (findSet(repIsland[(int) edges[idx1][0]]) == findSet(repIsland[(int) edges[idx1][1]])) {
					idx1++;
					continue;
				}
				// 가장 짧은 거리의 간선 선택
				union((int) edges[idx1][0], (int) edges[idx1][1]);
				
				// 총 간선거리 더하기
				sumDistance += edges[idx1][2];
				
				// pick과 idx 변경
				pick++;
				idx1++;
				
			}
			// 비용
			long cost = Math.round(ecoFee * sumDistance);
			
			// 출력
			System.out.println("#" + tc + " " + cost);
		}

	}
	static int findSet(int x) {
		if (repIsland[x] != x)
			repIsland[x] = findSet(repIsland[x]);
		return repIsland[x];
	}
	
	static void union(int x, int y) {
		repIsland[findSet(y)] = findSet(x);
	}

}
