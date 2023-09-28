import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	BOJ_1446 18316kb 232ms
public class Main_1446 {
	
	public static class Info {
		
		private int start;
		private int end;
		private int dist;
		
		public Info(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
		int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
		
		int[] dp = new int[D + 1];
		for (int i = 0; i <= D; i++) {
			dp[i] = i;
		}

		PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> {
			if(i1.start == i2.start) {
				if(i1.end == i2.end)
					return i1.dist - i2.dist;
				else
					return i1.end - i2.end;
			}else
				return i1.start - i2.start;
		});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 지름길의 시작 위치
			int e = Integer.parseInt(st.nextToken()); // 지름길의 도착 위치
			int d = Integer.parseInt(st.nextToken()); // 지름길의 길이
			
			pq.add(new Info(s,e,d));
		}
		
		for (int now = 0; now <= D; now++) {
			
			if(now > 1)
				dp[now] = Math.min(dp[now], dp[now - 1] + 1);

			while(!pq.isEmpty() && pq.peek().start == now) {
				
				Info n = pq.poll();
				
				if(n.end - now > n.dist && n.end <= D) {
					dp[n.end] = Math.min(dp[n.end], dp[now] + n.dist);
				}
				
			}
						
		}
		
		
		br.close();
		bw.write(Integer.toString(dp[D]));
		bw.flush();
		bw.close();
	}

}
