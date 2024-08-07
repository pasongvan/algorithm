package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 변수 및 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] count = new int[N+M+1];
			
			// 두개 카드 합 카운트
			for (int n=1; n<=N; n++) {
				for (int m=1; m<=M; m++) {
					count[n+m]++;
				}
			}
			
			// 확률 제일 높은 수가 몇 번 나오는지
			int max = 0;
			for (int i=2; i<=N+M; i++) {
				if (max < count[i])
					max = count[i];
			}
			
			// 확률 제일 높은 수가 몇 개인지
			int cnt = 0;
			for (int i=2; i<=N+M; i++) {
				if (count[i] == max) {
					cnt++;
				}
			}
			
			// 확률 제일 높은 수 배열로 저장
			int[] freq = new int[cnt];
			int idx = 0;
			for (int i=2; i<=N+M; i++) {
				if (count[i] == max) {
					freq[idx++] = i;
				}
			}
			
			// 출력
			System.out.print("#" + test_case + " ");
			for (int i=0; i<freq.length; i++) {
				System.out.print(freq[i] + " ");
			}
			System.out.println();
		}
	}
}