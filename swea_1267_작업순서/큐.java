import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for (int tc=1; tc<=10; tc++) {
			
			// 입력
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			// 정점 간 연결 여부(간선 정보)
			int[] inDegree = new int[V+1]; // 진입차수
			boolean[][] edges = new boolean[V+1][V+1];
			for (int i=0; i<E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				edges[from][to] = true;
				inDegree[to]++;
			}
			
			// 진입 차수 0인 정점 모두 큐에 넣기
			Queue<Integer> queue = new LinkedList<>();
			for (int i=1; i<=V; i++) {
				if (inDegree[i] == 0)
					queue.add(i);
			}
			
			// 테스트 케이스 번호 출력
			System.out.print("#" + tc + " ");
			
			// 큐가 빌 때까지 반복
			while (!queue.isEmpty()) {
				// 큐에서 정점 하나 빼기
				int curr = queue.poll();
				// 해당 정점 출력
				System.out.print(curr + " ");
				// 연결된 다른 정점 찾기
				for (int i=1; i<=V; i++) {
					if (edges[curr][i]) {
						edges[curr][i] = false; // 간선 제거
						inDegree[i]--; // 진입차수 1 감소
						// 만약 진입차수가 0이 되었다면 큐에 넣기
						if (inDegree[i] == 0)
							queue.add(i);
					}
				}
			}
			// 줄바꿈
			System.out.println();
		}

	}

}
