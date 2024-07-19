import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		int len = word.length();
		String[] letters = word.split("");
		int croAlphabet = 0;
		
		for (int i=1; i<len; i++) {
			if (letters[i].equals("=")) {
				if (letters[i-1].equals("c") || letters[i-1].equals("s"))
					croAlphabet++;
				else if (letters[i-1].equals("z")) {
					croAlphabet++;
					if (i>2 && letters[i-2].equals("z"))
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
		System.out.println(len-croAlphabet);
	}
}