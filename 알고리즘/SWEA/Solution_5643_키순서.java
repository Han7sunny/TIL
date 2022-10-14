import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 5643 112,548kb 1,112ms
public class Solution_5643_키순서 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine()); // 학생 수
			int M = Integer.parseInt(br.readLine()); // 키 비교한 횟수
			ArrayList<Integer>[] height = new ArrayList[N + 1];
			int[] from = new int[N + 1];
			int[] to = new int[N + 1];
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				height[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()); // a가 b보다 키 작음
				height[a].add(b);
			}

			for (int start = 1; start <= N; start++) {
				boolean[] visited = new boolean[N + 1];
				visited[start] = true;
				q.offer(start);
				while (!q.isEmpty()) {
					int now = q.poll();
					visited[now] = true;

					for (int i = 0; i < height[now].size(); i++) {
						int next = height[now].get(i);
						if (!visited[next]) {
							to[next]++;
							from[start]++;
							visited[next] = true;
							q.offer(next);
						}
					}
				}
			}

			for (int h = 1; h <= N; h++) {
				if (from[h] + to[h] == N - 1)
					count++;
			}

			answer.append("#").append(test_case).append(" ").append(count).append("\n"); // 자신의 키가 몇 번째인지 알 수 있는 학생 몇 명인지
		}
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}