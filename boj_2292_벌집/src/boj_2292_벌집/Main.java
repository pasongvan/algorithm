package boj_2292_벌집;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 및 변수 선언===========================================
        int N = sc.nextInt();
        int orbit = 1;
        int orbitMax = 1;
        int i = 0;
        
        // 계산======================================================
        while (N > orbitMax) {
            orbit++;
            i++;
            orbitMax += 6*i;
        }
        // 출력======================================================
        System.out.println(orbit);
    }
}