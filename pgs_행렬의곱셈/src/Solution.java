class Solution {
//    public int[][] solution(int[][] arr1, int[][] arr2) {
	public static void main(String[] args) {
    	int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
    	int[][] arr2 = {{3, 3}, {3, 3}};
    	
        // 코드 작성 부====================================================
		// 곱 행렬의 사이즈
    	int N = arr1.length;
		int M = arr2[0].length;
		
		// 곱 행렬 선언
		int[][] answer = new int[N][M];
		
		// 곱하기
		// arr3의 원소별로
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				// 곱하기
				for (int k=0; k<arr2.length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
				 
			}
		}
    	// =============================================================
		System.out.println(answer);
//        return answer;
    }
}