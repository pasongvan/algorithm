import java.util.PriorityQueue;

class Solution { 
	public int solution(int[][] jobs) { 
//	public static void main(String[] args) {
//		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		
		PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		PriorityQueue<int[]> q2 = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		
		int time = 0; 
		int sum = 0; 
		for (int i=0; i<jobs.length; i++) { 
			q1.offer(jobs[i]); 
		} 
		quit: 
		while (!q1.isEmpty()) { 
			int[] most; 
			while (!q1.isEmpty() && q1.peek()[0] <= time) { 
				q2.offer(q1.poll());
				} 
			if (!q2.isEmpty()) { 
				most = q2.poll(); 
				while (!q2.isEmpty()) { 
					q1.offer(q2.poll()); 
					} 
				} 
			else { 
				time++; break quit; 
				} 
			sum += time - most[0] + most[1]; 
			time += most[1]; 
			} 
		
//		System.out.println(sum / jobs.length);
		return sum / jobs.length;
	}
}