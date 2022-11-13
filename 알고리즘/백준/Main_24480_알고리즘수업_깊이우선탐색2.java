import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ 24480 104336kb 828ms
// Collection.sort(배열, Collections.reverseOrder())보다
// Collections.sort(배열)하고 역순으로 dfs하는 것이 속도 더 빠르게 나옴
public class Main_24480_알고리즘수업_깊이우선탐색2 {
	
	static ArrayList<Integer>[] graph;
	static int[] visitedOrder;
	static int order = 1;
	
	public static void dfs(int now) {
		visitedOrder[now] = order++;
	
		if (graph[now] != null) {
			Collections.sort(graph[now]);
			for (int i = graph[now].size() - 1; i >= 0 ; i--) {
				if (visitedOrder[graph[now].get(i)] == 0)
					dfs(graph[now].get(i));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new ArrayList[N + 1];
		visitedOrder = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (graph[u] == null)
				graph[u] = new ArrayList<>();
			graph[u].add(v);

			if (graph[v] == null)
				graph[v] = new ArrayList<>();
			graph[v].add(u);
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
