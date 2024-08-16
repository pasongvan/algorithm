import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] population;
	static int sum_population;
	static boolean[][] link;
	static int min_diff = 1000;
	static int[] area_indexes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 인구수 입력
		N = sc.nextInt();
		population = new int[N+1];
		for (int i=1; i<=N; i++) {
			population[i] = sc.nextInt();
			sum_population += population[i];
		}
		
		// 연결 구역 입력
		link = new boolean[N+1][N+1];
		for (int i=1; i<=N; i++) {
			int num_link = sc.nextInt();
			for (int j=0; j<num_link; j++) {
				int temp = sc.nextInt();
				link[i][temp] = true;
			}
		}
		
		// M(1~N/2)개를 선택하는 경우 반복문
		for (int M=1; M<=N/2; M++) {
			area_indexes = new int[M];
			method(M, 0, 0);
		}
		
		// 출력 
		if (min_diff == 1000) {
			min_diff = -1;
		}
		System.out.println(min_diff);
	}
	
	// 선거구역 나누고 인구 수 차이 계산하는 메소드
	static void method(int M, int depth, int last) {
		
		// 기저조건
		if (depth == M) {
			// 각 선거구끼리 연결되어 있는지 확인
			if (isLinked()) {
				// 선택된 선거구 인구수 계산
				int peaked_population = 0;
				for (int i=0; i<area_indexes.length; i++) {
					peaked_population += population[area_indexes[i]];
				}
				
				// 인구수 차이
				int diff = Math.abs(sum_population - 2*peaked_population);
				
				// 최솟값 갱신
				if (min_diff > diff)
					min_diff = diff;
			}
			return;
		}
		
		// 재귀
		for (int i=last+1; i<=N-(M-depth-1); i++) {
			area_indexes[depth] = i;
			method(M, depth+1, i);
		}
	}
	
	// 선거구 간 연결되어 있는지 확인하는 메소드
	static boolean isLinked() {
		
		// 선택된 선거구가 모두 연결되어 있는지 확인
		boolean allLinked = true;
		for (int i=0; i<area_indexes.length; i++) {
			int area = area_indexes[i];
			boolean OK = false;
			for (int j=0; j<area_indexes.length; j++) {
				if (i==j)
					continue;
				else if (link[area][area_indexes[j]]) {
					OK = true;
					break;
				}
			}
			if (!OK) {
				allLinked = false;
				break;
			}
		}
		if (!allLinked)
			return false;
		
		// 선택되지 않은 선거구가 모두 연결되어 있는지 확인
		int[] unpeaked_indexes = new int[N - area_indexes.length];
		int idx = 0;
		for (int i=1; i<=N; i++) {
			boolean OKK = true;
			for (int j=0; j<area_indexes.length; j++) {
				if (i == area_indexes[j]) {
					OKK = false;
					break;
				}
			}
			if (OKK) {
				unpeaked_indexes[idx++] = i;
			}
		}
		allLinked = true;
		for (int i=0; i<unpeaked_indexes.length; i++) {
			int area = unpeaked_indexes[i];
			boolean OK = false;
			for (int j=0; j<unpeaked_indexes.length; j++) {
				if (i==j)
					continue;
				else if (link[area][unpeaked_indexes[j]]) {
					OK = true;
					break;
				}
			}
			if (!OK) {
				allLinked = false;
				break;
			}
		}
		if (!allLinked)
			return false;
		
		return true;
	}
}




