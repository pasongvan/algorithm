package boj_2941_크로아티아;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 및 변수 설정
		String word = sc.next(); // 단어 입력
		int len = word.length(); // 단어 길이 저장
		String[] letters = word.split(""); // 한글자씩 쪼개어 저장
		int croAlphabet = 0; // 크로아티아 특수 알파벳만 세는 변수
		
		// `=`, `-`, `j` 나타나면 앞에를 확인함
		// 두번째 글자부터
		for (int i=1; i<len; i++) {
			if (letters[i].equals("=")) {
				if (letters[i-1].equals("c") || letters[i-1].equals("s"))
					croAlphabet++;
				// `dz=` 처리
				else if (letters[i-1].equals("z")) {
					croAlphabet++;
					if (i>=2 && letters[i-2].equals("d"))
						croAlphabet++;
				}
			}
			else if (letters[i].equals("-")) {
				if (letters[i-1].equals("c") || letters[i-1].equals("d"))
					croAlphabet++;
			}
			else if (letters[i].equals("j")) {
				if (letters[i-1].equals("l") || letters[i-1].equals("n"))
					croAlphabet++;
			}
		}
		// 전체 글자 수에서 크로아티아 알파벳 수만큼 뺌
		System.out.println(len-croAlphabet);
	}
}