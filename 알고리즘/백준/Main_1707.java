import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_1707	306316kb	1864ms
public class Main_1707 {

	static List<Integer>[] edge;
	static int[] color;

	public static class Node {

		private int num;
		private int color;

		public Node(int num, int color) {
			this.num = num;
			this.color = color;
		}
	}

	public static boolean checkBG(int start) {

		Queue<Node> q = new ArrayDeque<>();

		q.add(new Node(start, 1));

		while (!q.isEmpty()) {

			Node now = q.poll();
			color[now.num] = now.color;

			for (int next : edge[now.num]) {

				if (color[next] == color[now.num]) 
					return false;
				

				if(color[next] == 0)
					q.add(new Node(next, now.color * -1));
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < K; test_case++) {

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 그래프 정점 개수
			int E = Integer.parseInt(st.nextToken()); // 그래프 간선 개수

			edge = new ArrayList[V + 1];
			color = new int[V + 1];

			for (int i = 1; i <= V; i++) {
				edge[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				edge[u].add(v);
				edge[v].add(u);
			}
			
			boolean result = true;
			for (int i = 1; i <= V; i++) {
				if(color[i] == 0) {
					
					if(!checkBG(i)) {
						result = false;
						break;
					}
					
				}
			}

			if (result)
				answer.append("YES\n");
			else
				answer.append("NO\n");

		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
