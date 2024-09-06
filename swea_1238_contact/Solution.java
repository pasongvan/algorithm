import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	
	static List<Integer>[] phone;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc=1; tc<=10; tc++) {
			
			// 입력
			int N = sc.nextInt();
			int start = sc.nextInt();
			phone = new ArrayList[101];
			for (int i=0; i<101; i++) {
				phone[i] = new ArrayList<Integer>();
			}
			for (int i=0; i<N/2; i++) {
				int income = sc.nextInt();
				int outcome = sc.nextInt();
				phone[income].add(outcome);
			}
			
			// 초기화
			visit = new boolean[101];
			
			// BFS 호출
			int ans = bfs(start);
			
			// 결과 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int bfs(int start) {
		
		// 발신자 방문처리
		visit[start] = true;
		
		// 큐에 발신자와 뎁스 넣어줌
		Queue<int[]> queue = new LinkedList<>();
		int depth = 1;
		int[] tmp = {start, depth};
		queue.add(tmp);
		
		// 수신자 번호
		int end = 0;
		
		// 큐가 빌 때까지 반복
		while(!queue.isEmpty()) {
			// 큐에서 하나 빼고
			// 뎁스가 더 크면 수신자 갱신
			// 뎁스가 같을 땐 수신자가 더 크면 갱신
			int[] arr = queue.poll();
			
			if (arr[1] > depth) {
				depth = arr[1];
				end = arr[0];
			}
			else if (arr[0] > end)
				end = arr[0];
			
			// 큐에서 뺀 애가 전화걸 수 있는 애들 큐에 넣음
			for (int i=0; i<phone[arr[0]].size(); i++) {
				int newMan = phone[arr[0]].get(i);
				
				// 방문하지 않았으면 큐에 넣는다.
				if (!visit[newMan]) {
					int[] arr2 = {newMan, arr[1]+1};
					queue.add(arr2);
					visit[newMan] = true; // 방문처리
				}
			}
		}
		// 마지막 수신자 반환
		return end;
	}
}




