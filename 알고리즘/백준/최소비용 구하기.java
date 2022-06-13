import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 1916
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] bus = new ArrayList[n+1]; // Map 쓰지 않기!
		int[] dist = new int[n+1];
		boolean[] visited = new boolean[n+1];

		
		for(int i = 1; i <= n; i++) {
			bus[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			bus[s].add(new int[] {e,w});
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {start,0});
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(!visited[now[0]]) {
				visited[now[0]] = true;
				
				for(int[] next : bus[now[0]]) {
					if(!visited[next[0]] && dist[next[0]] > dist[now[0]] + next[1]) {
						dist[next[0]] = dist[now[0]] + next[1];
						pq.add(new int[] {next[0], dist[next[0]]});
					}
				}
			}
		}
		br.close();
		bw.write(Integer.toString(dist[end]));
		bw.flush();
		bw.close();
	}
}
