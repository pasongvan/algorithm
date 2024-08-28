package swea_14229_백만개의정수정렬;

import java.util.Scanner;

public class Solution {
	
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열에 담기
		arr = new int[1000000];
		for (int i=0; i<1000000; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 정렬
		sort(0, 999999);
		
		// 출력
		System.out.println(arr[500000]);
		
	}
	// 로무토
	static void sort(int left, int right) {
		// 기저조건
		if (left >= right) return;
		
		int pivot = partition(left, right);
		sort(left, pivot-1); // pivot 기준 왼쪽
		sort(pivot+1, right); // pivot 기준 오른쪽
	}
	
	// 파티션
	static int partition(int left, int right) {
		
		int pivot = right;
		int i = left-1;
		int j = left;
		
		while (j < right) {
			// 인덱스 j가 pivot보다 작거나 같은 경우
			if (arr[j] <= arr[pivot]) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			j++;
		}
		// pivot 위치는 i+1, 바꿔주기
		int tmp = arr[i+1];
		arr[i+1] = arr[pivot];
		arr[pivot] = tmp;
		
		// pivot 위치 반환
		return i+1;
	}
}
