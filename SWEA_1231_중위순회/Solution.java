package SWEA_1231_중위순회;

import java.util.Scanner;

public class Solution {
	
	static int N;
	static Object[][] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			
			// N입력
			N = sc.nextInt();
			sc.nextLine();
			tree = new Object[N+1][3]; // 0: 데이터, 1: left, 2: right
			
			// tree 데이터 입력
			for (int i=1; i<=N; i++) {
				String oneLine = sc.nextLine();
				String[] temp = oneLine.split(" ");
				tree[i][0] = temp[1];
				if (temp.length>2) {
					tree[i][1] = Integer.parseInt(temp[2]);
					
					if (temp.length>3) {
						tree[i][2] = Integer.parseInt(temp[3]);
					}
				}
			}
			
			// inorder 출력
			System.out.print("#" + test_case + " ");
			inorder(1);
			System.out.println();
		}
	}
	
	static void inorder(Object root) {
		// 기저조건
		if (root==null)
			return;
		
		// 중위 출력
		inorder(tree[(int)root][1]);
		System.out.print(tree[(int)root][0]);
		inorder(tree[(int)root][2]);
	}
}