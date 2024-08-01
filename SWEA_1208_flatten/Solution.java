package SWEA_1208_flatten;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 변수 설정 및 입력====================================
            int dump = sc.nextInt();
            int[] boxes = new int[100];
            int cnt = 0;
            for (int i=0; i<100; i++) {
                boxes[i] = sc.nextInt();
            }
            // 최초 1회 정렬=======================================
            boxes = countingSort(boxes, dump);
            // 정렬과 덤프 반복=====================================
            while (cnt < dump && (boxes[99] - boxes[0]) > 1) { // 덤프횟수 초과 or 평탄화 완료 시 중단
                // 덤프
                boxes[0]++;
                boxes[99]--;
                cnt++; // 횟수 카운트
                // 정렬
                boxes = countingSort(boxes, dump);
            }
            // 출력============================================
            int diff = boxes[99] - boxes[0];
            System.out.println("#" + test_case + " " + diff);
		}
	}
    
    // 카운팅 정렬 메소드=========================================
    static int[] countingSort(int[] boxes, int dump) {
        int[] newArr = new int[101]; // 인덱스 번호와 숫자 맞춰줌
        for (int i=0; i<100; i++) {
            newArr[boxes[i]]++; // 카운팅 배열 저장
        }
        for (int i=2; i<101; i++) {
            newArr[i] += newArr[i-1]; // 누적 합 배열
        }
        int[] result = new int[100];
        for (int i=99; i>=0; i--) { // 오름차순 정렬
            newArr[boxes[i]]--;
            result[newArr[boxes[i]]] = boxes[i];
        }
        return result;
    }
}