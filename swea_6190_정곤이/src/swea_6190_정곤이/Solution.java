package swea_6190_정곤이;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			int N = sc.nextInt();
			int[] numbers = new int[N];
			for (int i=0; i<N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			// 크기대로 정렬
			Arrays.sort(numbers);
			
			// 최대곱 저장 변수
			long max = -1;
			
			// 큰거부터 두개식 곱해보기
			for (int i=N-1; i>=1; i--) {
				for (int j=i-1; j>=0; j--) {
					// 두 수 곱하기
					long multi = numbers[i] * numbers[j];
					// 최대곱보다 곱이 클 때만 확인
					if (max < multi) {
						// 단조증가 체크
						// 문자열로 변환
						String strMulti = Long.toString(multi);
						// 한글자씩 char로 변환해서 값이 증가하는지 체크
						for (int idx=1; idx<strMulti.length(); idx++) {
							// 앞이 뒤보다 더 크면
							if (strMulti.charAt(idx-1) > strMulti.charAt(idx)) {
								break; // 중단
							}
							// 한번도 안결렸으면 max 갱신
							if (strMulti.length()==1 || idx == strMulti.length()-1)
								max = multi;
						}
					}
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + max);
		}

	}

}
