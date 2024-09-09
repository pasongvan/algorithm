import java.util.Scanner;
import java.util.Stack;

class 스택 {
	
	static int V, E;
	static boolean[][] edges;
	static int[] inDegree;
	static Stack<Integer> stack;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		for (int tc=1; tc<=10; tc++) {
			
			// 입력
			V = sc.nextInt();
			E = sc.nextInt();
			
			// 간선 정보, 진입 차수 입력
			edges = new boolean[V+1][V+1];
			inDegree = new int[V+1];
			for (int i=0; i<E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				edges[from][to] = true;
				inDegree[to]++;
			}
			
			// 스택, 방문 배열 초기화
			stack = new Stack<>();
			visit = new boolean[V+1];
			
			// 모든 정점 순회
			for (int i=1; i<=V; i++) {
				// 진입차수 0이면 dfs 호출
				if (inDegree[i] == 0)
					dfs(i);
			}
			// 스택의 원소 모두 꺼내어 출력
			System.out.print("#" + tc + " ");
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}
	static void dfs(int i) {
		// 방문처리
		visit[i] = true;
		// 모든 정점 순회
		for (int j=1; j<=V; j++) {
			// 방문했거나 연결이 안되어있으면 continue
			if (visit[j] || !edges[i][j]) continue;
			// dfs 재귀
			dfs(j);
		}
		// 해당 정점 스택에 push
		stack.push(i);
	}
}




