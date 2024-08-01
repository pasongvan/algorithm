import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			
			// 변수 및 입력============================================
			String oneLine = sc.next();
			int numCard = oneLine.length() / 3;
			int[][] cards = new int[4][13]; //S=0, D=1, H=2, C=3
			boolean error = false;
			
			// 카드 분류===============================================
			// 카드 개수만큼 정보 입력
			quit_for:
			for (int i=0; i<numCard; i++) {
				// 카드 무늬와 번호 분리
				String pattern = oneLine.substring(3*i, 3*i+1);
				int number = Integer.parseInt(oneLine.substring(3*i+1, 3*i+3));
				
				// 카드 배열에 저장
				switch (pattern) {
				case "S" : cards[0][number-1]++;
						   if (cards[0][number-1] > 1) {
							   error = true;
							   break quit_for;
						   }
						   break;
				case "D" : cards[1][number-1]++;
						   if (cards[1][number-1] > 1) {
							   error = true;
							   break quit_for;
						   }
						   break;
				case "H" : cards[2][number-1]++;
						   if (cards[2][number-1] > 1) {
							   error = true;
							   break quit_for;
						   }
						   break;
				case "C" : cards[3][number-1]++;
						   if (cards[3][number-1] > 1) {
							   error = true;
							   break quit_for;
						   }
						   break;
				}
			}
			// 없는 카드 개수 세기=========================================
			int[] cntEmpty = new int[4];
			for (int i=0; i<4; i++) {
				for (int j=0; j<13; j++) {
					if (cards[i][j] == 0)
						cntEmpty[i]++;
				}
			}
			// 출력=====================================================
			System.out.print("#" + test_case + " ");
			if (error)
				System.out.print("ERROR");
			else {
				for (int i=0; i<4; i++) {
					System.out.print((cntEmpty[i]) + " ");
				}
			}
			System.out.println();
		}

	}

}
