import java.util.Arrays;
import java.util.Scanner;

class Solution { 
	
	static int N;
	static int[][] depth;
	static int[][] dist;
	static boolean[][] visit;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			// 입력
			N = sc.nextInt();
			depth = new int[N][N];
			for (int i=0; i<N; i++) {
				String oneLine = sc.next();
				for (int j=0; j<N; j++) {
					depth[i][j] = oneLine.charAt(j) - '0';
				}
			}
			
			// 변수 초기화
			dist = new int[N][N];
			for (int i=0; i<N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			visit = new boolean[N][N];
			
			// 0,0 에서 출발
			dist[0][0] = 0;
			
			// 다익스트라 메소드 호출
			dijkstra(0, 0);
			
			// 결과 출력
			System.out.println("#" + tc + " " + dist[N-1][N-1]);
		}
	}
	
	// 다익스트라
	static void dijkstra(int row, int col) {
		
		// 기저조건: 도착지 도착 시 종료
		if (row==N-1 && col==N-1) return;
		
		// 방문처리
		visit[row][col] = true;
		
		// 갈 수 있는 곳 dist 갱신
		for (int idx=0; idx<4; idx++) {
			// 방문했거나 인덱스 벗어나는 경우 넘김
			if (row+dr[idx]<0 || row+dr[idx]>=N || col+dc[idx]<0 || col+dc[idx]>=N ||
				visit[row+dr[idx]][col+dc[idx]])
				continue;
			// 갈 수 있는 칸은 거리 갱신
			if (dist[row+dr[idx]][col+dc[idx]] > dist[row][col] + depth[row+dr[idx]][col+dc[idx]]) {
				dist[row+dr[idx]][col+dc[idx]] = dist[row][col] + depth[row+dr[idx]][col+dc[idx]];
			}
		}
		
		// 그 다음 갈 칸 찾기
		int min = Integer.MAX_VALUE;
		int newRow = -1;
		int newCol = -1;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (visit[i][j]) continue;
				if (min > dist[i][j]) {
					min = dist[i][j];
					newRow = i;
					newCol = j;
				}
			}
		}
		dijkstra(newRow, newCol);
	}
	
}

