package SWEA_1966_숫자를정렬하자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			
			// N크기 1차원 배열
			int[] arr = new int[N];
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 0번 인덱스는 정렬 완료
			// 1번 인덱스부터 끝까지 비교
			for (int i=1; i<N; i++) {
				// 삽입할 원소 임시 저장
				int temp = arr[i];
				// 이미 정렬된 원소 뒤에서부터 비교
				int j;
				// 비교대상이 더 크면 비교대상 한 칸 뒤로 이동
				for (j=i-1; j>=0 && arr[j]>temp; j--) {
					arr[j+1] = arr[j];
				}
				// 작거나 같은 곳을 발견하면 삽입할 원소 그 뒤로 저장
				arr[j+1] = temp;
			}
			
			// 출력
			System.out.print("#" + test_case +" ");
			for (int i=0; i<N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}