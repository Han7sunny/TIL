import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Main {
	static boolean[] visited;
	static Map<Integer, List<Integer>> nodes;
	public static void check(int node) {
		if(visited[node])
			return; // 사이클 마지막
		
		visited[node] = true;
		for(int i = 0; i < nodes.get(node).size(); i++)
			if(!visited[nodes.get(node).get(i)])
				check(nodes.get(node).get(i));
		
	}
	public static void main(String[] args) throws IOException { // 11724
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		visited = new boolean[n+1];
		nodes = new HashMap<>();	
		
		for(int i = 1; i <= n; i++) 
			nodes.put(i, new ArrayList<>());

		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			nodes.get(u).add(v);
			nodes.get(v).add(u);
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				answer++;
				check(i);
			}
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
