import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            sc.nextLine();
            String oneLine = sc.nextLine();
            String[] words = oneLine.split(" ");
            
            System.out.print("#" + test_case +" ");
            for (int i=0; i<N/2; i++) {
                System.out.print(words[i] + " ");
                System.out.print(words[N - N/2 + i] + " ");
                if (i == N/2-1 && N%2==1)
                    System.out.print(words[N/2]);
            }
            System.out.println();
		}
	}
}