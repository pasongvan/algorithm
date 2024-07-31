package SWEA_1213_String;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
            // 변수 설정 및 입력=================================
            String targetString = sc.next();
            String[] target = targetString.split("");
            int len = target.length;
            String sentenceString = sc.next();
            String[] sentence = sentenceString.split("");
            int cnt = 0;
            
            // 검색============================================
            // 문장 전체 순회 (끝에서 검색 단어 길이 전까지만)
            for (int i=0; i<=sentence.length-len; i++) {
                // 첫글자 찾으면
                if (sentence[i].equals(target[0])) {
                    // 뒤에 글자 같은지 확인
                    for (int j=1; j<len; j++) {
                        if (!(sentence[i+j].equals(target[j]))) {
                            break; // 다르다면 반복문 탈출
                        }
                        if (j == len-1)
                            cnt++; // 모두 통과했다면 카운트
                    }
                }
            }
            // 출력===============================================
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}