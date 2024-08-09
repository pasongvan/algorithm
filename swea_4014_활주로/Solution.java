
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			
			// NxN 배열 생성
			int[][] land = new int[N][N];
			
			// 입력
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					land[i][j] = sc.nextInt();
				}
			}
			
			// 활주로 건설 가능 줄 개수 변수
			int able = 0;
			
			// 행 검사
			for (int i=0; i<N; i++) {
				boolean ok = true;
				for (int j=0; j<N; j++) {
					
					// 1. 인접한 수와 차이가 2 이상인 곳이 있으면 안됨
					if (j>0 && Math.abs(land[i][j] - land[i][j-1])>1) {
						ok = false;
						break;
					}
					
					// 2. 바깥쪽이 더 낮은데 길이가 X보다 짧으면 안됨
					if (j==0) {
						for (int x=0; x<X; x++) {
							if (land[i][j] != land[i][x]) {
								ok = false;
								break;
							}
						}
					} else if (j==N-1) {
						for (int x=N-1; x>=N-X; x--) {
							if (land[i][j] != land[i][x]) {
								ok = false;
								break;
							}
						}
					}
					
					// 3. X보다 빠르게 높이가 변하면 안됨
					
				}
				if (ok)
					able++;
			}
			
			// 출력
			System.out.println("#" + test_case + " " + able);
		}
	}
}
// 1. 인접한 수와 차이가 2이상이면 안됨
// 2. X보다 빠르게 높이가 변하면 안됨
// 3. 바깥쪽이 더 낮은데 길이가 x보다 짧으면 안됨




