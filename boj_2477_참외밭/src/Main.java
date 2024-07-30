import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//변수 설정 및 입력==========================================
		int K = sc.nextInt();
		int[][] border = new int[8][2];
		int east = 0;
		int south = 0;
		int wholeArea = 0;
		int partArea = 0;
		boolean shape = false; // true는 ㅁ모양, false는 ㄱ모양
		int[] countDirection = new int[5]; // 각 방향이 몇번 나왔는지 담는 변수
		
		// 양 끝은 비워둠
		for (int i=1; i<7; i++) {
			for (int j=0; j<2; j++) {
				border[i][j] = sc.nextInt();
			}
		}
		
		// 밭 모양 판정=============================================
		for (int i=1; i<7; i++) {
			countDirection[border[i][0]]++;
			if (countDirection[border[i][0]] == 2) {
				if (border[i-1][0] == border[i][0])
					shape = true; // ㅁ모양
			}
		}
		// 전체 넓이 계산 (ㅁ모양 밭인 경우)=============================
		for (int i=1; i<7; i++) {
			// 동쪽으로 간 길이 계산 (가로 길이)
			if (border[i][0] == 1)
				east += border[i][1];
			// 남쪽으로 간 길이 계산 (세로 길이)
			else if (border[i][0] == 3)
				south += border[i][1];
		}
		wholeArea = east * south;
		
		// ㄱ모양 밭인 경우===========================================
		int partDir1 = 0; // 부분 사각형 한 변의 길이
		int partDir2 = 0; // 부분 사각형 다른 한 변의 길이
		int partDistance1 = 0;
		int partDistance2 = 0;
		int tmp = 0; // 두 변을 구분하기 위한 임시변수
		if (shape == false) {
			// 면적 제외할 사각형의 두 방향 체크
			for (int i=1; i<=4; i++) {
				if (countDirection[i] == 2) {
					if (tmp == 0) {
						partDir1 = i;
						tmp++;
					}else 
						partDir2 = i;
				}
			}
			// 면적 제외할 사각형 변의 길이 구하기
			for (int i=1; i<7; i++) {
				// direction1
				if (border[i][0] == partDir1) {
					if ((border[i-1][0]==0 || border[i-1][0]==partDir2) && (border[i+1][0]==0 || border[i+1][0]==partDir2)) {
						partDistance1 = border[i][1];
					}
					if ((border[i-1][0]==partDir2) && (border[i+1][0]==partDir2)) {
						partDistance1 = border[i][1];
					}
				}
				// direction2
				else if (border[i][0] == partDir2) {
					if ((border[i-1][0]==0 || border[i-1][0]==partDir1) && (border[i+1][0]==0 || border[i+1][0]==partDir1)) {
						partDistance2 = border[i][1];
					}
					if ((border[i-1][0]==partDir1) && (border[i+1][0]==partDir1)) {
						partDistance2 = border[i][1];
					}
				}
			}
			partArea = partDistance1 * partDistance2;
			wholeArea -= partArea;
		}
		System.out.println(partDistance1);
	}
}
