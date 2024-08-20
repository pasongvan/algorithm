import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] grad;
	static int maxScore;
	static int L;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			N = sc.nextInt();
			L = sc.nextInt();
			grad = new int[N][2];
			for (int i=0; i<N; i++) {
				grad[i][0] = sc.nextInt();
				grad[i][1] = sc.nextInt();
			}
			maxScore = 0;
			
			// 조합개수 N부터 1까지
			for (int M=N; M>=1; M--) {
				combination(M, 0, 0, 0, -1);
			}
			
			// 출력
			System.out.println("#" + test_case + " " + maxScore);
		}
	}
	// 조합 계산 메소드
	static void combination(int M, int depth, int score, int calories, int last) {
		// 기저조건1: 제한 칼로리 초과
		if (calories > L)
			return;
		// 기저조건2: 조합 개수 도달
		if (depth==M) {
			// 최대 맛 점수 갱신
			if (maxScore < score) {
				maxScore = score;
			}
			return;
		}
		
		// 재귀
		for (int i=last+1; i<=N-(M-depth); i++) {
			combination(M, depth+1, score+grad[i][0], calories+grad[i][1], i);
		}
	}
}