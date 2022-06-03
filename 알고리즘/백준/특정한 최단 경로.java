import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
public class Main {
	static Map<Integer,Map<Integer,Integer>> node;
	static final int INF = 200000000;
	public static int shortWay(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		boolean[] visited = new boolean[node.size() + 1];
		int[] dist = new int[node.size() + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		pq.add(new int[] {start,0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();

			if(!visited[now[0]]) {
				visited[now[0]] = true;
				for(Entry<Integer,Integer> next : node.get(now[0]).entrySet()) {
					if(dist[next.getKey()] > now[1] + next.getValue() && !visited[next.getKey()]) {
						dist[next.getKey()] = now[1] + next.getValue();
						pq.add(new int[] {next.getKey(), dist[next.getKey()]});
					}
				}
			}
		}
		return dist[end];
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		node = new HashMap<>();
		for(int i = 1; i <= n; i++)
			node.put(i, new HashMap<>());
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			node.get(a).put(b, c);
			node.get(b).put(a, c);
		}
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		long uToV = 0;
		uToV += shortWay(1,u);
		uToV += shortWay(u,v);
		uToV += shortWay(v,n);		
		
		long vToU = 0;
		vToU += shortWay(1,v);
		vToU += shortWay(v,u);
		vToU += shortWay(u,n);
		
		long answer = Math.min(uToV, vToU);
		if(answer >= INF)
			answer = -1;
		br.close();
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
