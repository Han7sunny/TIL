import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 1753
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		ArrayList<int[]>[] bus = new ArrayList[V+1];
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i = 1; i <= V; i++) {
			bus[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			bus[s].add(new int[] {e,w});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.add(new int[] {K,0});
		dist[K] = 0;
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
		
		StringBuilder sb = new StringBuilder();
		for(int vertex = 1; vertex <= V; vertex++) {
			if(dist[vertex] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(Integer.toString(dist[vertex]) + "\n");
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
