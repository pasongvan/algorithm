class Solution {
	
	static String[] place;
	static boolean[][] visit;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static int[] solution(String[][] places) {
        
        // 정답 담을 배열
        int[] answer = new int[5];
        
        // 5개의 케이스 반복
        for (int test_case=0; test_case<5; test_case++) {
            place = places[test_case];
            
            // dfs 방문 여부 배열
            visit = new boolean[5][5];
            
            // 결과값 담을 변수
            int result = 1;
            
            // 모든 자리에 대해 순회
            // P에 대해서는 dfs 탐색
            quit_for:
            for (int row=0; row<5; row++) {
                for (int col=0; col<5; col++) {
                    String seat = place[row].substring(col, col+1);
                    
                    // 사람이 있고, 방문하지 않았다면 dfs 탐색
                    if (seat=="P" && !visit[row][col]) {
                        result = dfs(row, col, 0);
                        // 결과로 0이 나왔으면 break
                        if (result == 0)
                            break quit_for;
                    }
                }
            }
            // 결과 저장
            answer[test_case] = result;
        }
         return answer;
    }
    
    // dfs 메소드
    public static int dfs(int row, int col, int distance) {
    	visit[row][col] = true;
    	
    	// 거리 안에 사람이 있으면 0 리턴
    	if (distance!=0 && place[row].substring(col, col+1).equals("P"))
        	return 0;
    	
    	distance++;
    	
        // 네 방향 탐색
    	for (int didx=0; didx<4; didx++) {
            int newRow = row + dr[didx];
            int newCol = col + dr[didx];
            
            // distance 2 미만 & 인덱스 범위 내 & 빈 테이블이면
            if (distance<2 && newRow>=0 && newRow<5 && newCol>=0 && newCol<5 && place[newRow].substring(newCol, newCol+1).equals("O")) {
            	dfs(newRow, newCol, distance);
            }
        	return 1;    		
    	}
    }
}


