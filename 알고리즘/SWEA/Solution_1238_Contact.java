import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 1238 Contact 18,252kb 118ms
// Queue에 연락을 받는 사람과 시간을 넣어주고 최대 시간이 갱신될 경우 그에 해당하는 사람의 숫자가 최대가 되도록 하였습니다.
public class Solution_1238_Contact {
	static HashMap<Integer, Integer> times;
	static ArrayList<Integer>[] tel;
	static boolean[] visited;
	static int maxTime;

	public static void call(int start, int time) {

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { start, time });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (tel[now[0]] != null) {

				for (int i = 0; i < tel[now[0]].size(); i++) {
					if (!visited[tel[now[0]].get(i)]) {
						visited[tel[now[0]].get(i)] = true;
						q.offer(new int[] { tel[now[0]].get(i), now[1] + 1 });
					}
				}
			}

			if (now[1] >= maxTime) {
				maxTime = now[1];
				if (times.containsKey(now[1])) {
					times.put(now[1], times.get(now[1]) < now[0] ? now[0] : times.get(now[1]));
				} else
					times.put(now[1], now[0]);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			times = new HashMap<>();
			maxTime = 0;
			tel = new ArrayList[101];
			visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (tel[from] == null)
					tel[from] = new ArrayList<>();
				tel[from].add(to);
			}

			call(start, 0);

			result.append("#").append(test_case).append(" ").append(times.get(maxTime)).append("\n");
		}
		bw.write(result.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
