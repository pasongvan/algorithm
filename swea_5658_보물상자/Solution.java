import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 입력
			int N = sc.nextInt();
			int K = sc.nextInt();
			String oneLine = sc.next();
			
			// char 배열로 받음
			char[] arrChar = oneLine.toCharArray();
			
			// long 배열로 변환
			long[] arrInt = new long[N];
			for (int i=0; i<N; i++) {
				arrInt[i] = arrChar[i] - '0';
				if (arrInt[i]>9)
					arrInt[i] -= 7;
			}
			
			// len = 로테이션 횟수 = 한변에 있는 숫자
			int len = N/4;
			
			// 로테이션 횟수 만큼 반복문
			// 리스트에 모든 수 담기
			List<Long> list = new ArrayList<>();
			for (int rot=0; rot<len; rot++) {
				for (int i=len-1+rot; i<N+rot; i+=len) {
					long sum = 0;
					long sixteen = 1;
					for (int j=0; j<len; j++) {
						if (i-j<N) {
							sum += arrInt[i-j]*sixteen;
							sixteen *= 16;
						}
						else {
							sum += arrInt[i-j-N]*sixteen;
							sixteen *= 16;
						}
					}
					list.add(sum);
				}
			}
			
			// 배열로 변환
			long[] arrLong = new long[list.size()];
			for (int i=0; i<list.size(); i++) {
				arrLong[i] = list.get(i);
			}
			
			// 정렬
			Arrays.sort(arrLong);
			
			// 중복 제외하고 K번째 수 출력
			long answer = -1;
			int cnt = 0;
			for (int i=arrLong.length-1; i>0; i--) {
				if (arrLong[i] != arrLong[i-1]) {
					cnt++;
					if (cnt==K) {
						answer = arrLong[i];
						break;
					}
				}
			}
			if (answer==-1)
				answer = arrLong[0];
			
			// 출력
			System.out.println("#" + test_case + " " + answer);
		}
	}
}

// char 배열로 받음
// int 배열로 변환
// len = 한변에 몇개 숫자 들어가는지 구함
// len 만큼 반복문
// 리스트에 모든 수 담기
// 배열로 변환
// 정렬
// 중복되는거 제외하고 K번째 수 출력