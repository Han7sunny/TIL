import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
public class Main { // 14938
	static Map<Integer,Map<Integer,Integer>> road;
	static int[] item;
	static int m;
	static int answer;
	public static void itemCount(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		boolean[] visited = new boolean[road.size() + 1];
		int sum = 0;
		pq.add(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(!visited[now[0]]) {
				visited[now[0]] = true;
				if(now[1] <= m) {
					sum += item[now[0]];
				}
				
				for(Entry<Integer,Integer> next : road.get(now[0]).entrySet()) {
					if(!visited[next.getKey()] && now[1] + next.getValue() <= m) {
						pq.add(new int[] {next.getKey(), now[1] + next.getValue()});
					}
				}
			}
		}
		answer = Math.max(answer, sum);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		road = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 지역의 개수
		m = Integer.parseInt(st.nextToken()); // 수색 범위
		int r = Integer.parseInt(st.nextToken()); // 길의 개수
		item = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			road.put(i, new HashMap<>());
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			int l = Integer.parseInt(st.nextToken()); // 길의 길이
			
			road.get(a).put(b, l);
			road.get(b).put(a, l);
		}
		
		for(int i = 1; i <= n; i++)
			itemCount(i);
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
