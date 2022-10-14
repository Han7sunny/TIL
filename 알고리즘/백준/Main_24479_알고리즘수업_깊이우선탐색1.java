import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ 24479 103644kb 872ms
public class Main_24479_알고리즘수업_깊이우선탐색1 {
	
	static int cnt = 0;
	static ArrayList<Integer>[] nodes;
	static int[] visitedOrder;
	
	public static void dfs(int start) {
		visitedOrder[start] = ++cnt;

		if(nodes[start] != null) {
			Collections.sort(nodes[start]);
			for (int i = 0; i < nodes[start].size(); i++) {
				if(visitedOrder[nodes[start].get(i)] == 0) {
					dfs(nodes[start].get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 시작 정점
		
		nodes = new ArrayList[N+1];
		visitedOrder = new int[N+1];		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if(nodes[u] == null) {
				nodes[u] = new ArrayList<>();
			}
			
			if(nodes[v] == null) {
				nodes[v] = new ArrayList<>();
			}
			
			nodes[u].add(v);
			nodes[v].add(u);
			
		}

		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			answer.append(visitedOrder[i]).append("\n");
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
