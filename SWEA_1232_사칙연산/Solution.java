package SWEA_1232_사칙연산;

import java.util.Scanner;

public class Solution {
	
	static int N;
	static String[][] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			
			// 입력
			N = sc.nextInt();
			sc.nextLine();
			int size = 0;
			for (int i=0; i<=10; i++) {
				double pow2 = Math.pow(2, i);
				if (N <= pow2) {
					size = (int) pow2;
					break;
				}
			}
			tree = new String[size][3];
			
			// tree에 입력
			for (int i=1; i<=N; i++) {
				String oneLine = sc.nextLine();
				String[] temp = oneLine.split(" ");
				tree[i][0] = temp[1];
				if (temp.length>2) {
					tree[i][1] = temp[2];
					if (temp.length>3) {
						tree[i][2] = temp[3];
					}
				}
			}			
			// 계산
			calc(1);
			
			// 출력
			System.out.println("#" + test_case + " " + tree[1][0]);
		}
	}
	// 계산 메소드
	static void calc(int root) {
		
		// 기저조건
		if (tree[root][1]==null || tree[root][2]==null)
			return;
		
		// L
		calc(Integer.parseInt(tree[(int)root][1]));
		// R
		calc(Integer.parseInt(tree[(int)root][2]));
		
		// V
		
		if (tree[root][0].equals("+"))
			tree[root][0] = (Integer.parseInt(tree[Integer.parseInt(tree[root][1])][0]) + Integer.parseInt(tree[Integer.parseInt(tree[root][2])][0]))+"";
		else if (tree[(int)root][0].equals("-"))
			tree[(int)root][0] = (Integer.parseInt(tree[Integer.parseInt(tree[root][1])][0]) - Integer.parseInt(tree[Integer.parseInt(tree[root][2])][0]))+"";
		else if (tree[(int)root][0].equals("*"))
			tree[(int)root][0] = (Integer.parseInt(tree[Integer.parseInt(tree[root][1])][0]) * Integer.parseInt(tree[Integer.parseInt(tree[root][2])][0]))+"";
		else 
			tree[(int)root][0] = (Integer.parseInt(tree[Integer.parseInt(tree[root][1])][0]) / Integer.parseInt(tree[Integer.parseInt(tree[root][2])][0]))+"";
	}
}

