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

//	BOJ_1005 248536kb 764ms
public class Main_1005 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 건물의 개수
			int K = Integer.parseInt(st.nextToken()); // 건물간의 건설순서 규칙 개수

			Queue<Integer> q = new ArrayDeque<>();
			int[] time = new int[N + 1];
			int[] sumTime = new int[N + 1];
			int[] degree = new int[N + 1];	//	진입차수
			List<Integer>[] list = new ArrayList[N + 1];	//	다음 건물 리스트
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			// 건물당 건설에 걸리는 시간
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				degree[Y]++;
				list[X].add(Y);
			}

			for (int i = 1; i <= N; i++) {
				if (degree[i] == 0) {
					sumTime[i] = time[i];
					q.add(i);
				}
			}

			// 건설해야 할 건물의 번호
			int W = Integer.parseInt(br.readLine());

			while (!q.isEmpty()) {
				int now = q.poll();
				if (now == W)
					break;

				for (int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i);
					degree[next]--;
					sumTime[next] = Math.max(sumTime[next], sumTime[now] + time[next]);
					if (degree[next] == 0) {
						q.add(next);
					}
				}

			}
			answer.append(sumTime[W]).append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();

	}

}
