import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 변수 설정 및 입력============================
            String word;
            String[] wordArray = new String[30];
            int wordLen = 0;
            int idx[] = new int[30];
            word = sc.next();
            wordArray = word.split("");
            
            // 첫글자가 나오는 인덱스들 찾기=========================
            for (int i=1; i<30; i++) {
                if (wordArray[0].equals(wordArray[i])) {
                    idx[i] = 1;
                }
            }
            // 검사=========================================
            quit_for:
            for (int i=1; i<30; i++) {
                if (idx[i] == 1) {
                    int cnt = 0;
                    for (int j=0; j<i; j++) {
                        if (!(wordArray[j].equals(wordArray[i+j]))) {
                            break;
                        }
                        cnt++;
                        if (cnt == i) {
                            wordLen = i;
                            break quit_for;
                        }
                    }
                }
            }
            //출력=============================================
            System.out.println("#" + test_case + " " + wordLen);               
		}
	}
}