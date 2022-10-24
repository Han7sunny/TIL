import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 18352 282480kb 896ms
public class Main_18352_특정거리의도시찾기 {

	static class City implements Comparable<City> {
		int num, dist;

		public City(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(City c) {
			return this.dist - c.dist;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수
		int K = Integer.parseInt(st.nextToken()); // 거리 정보
		int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		ArrayList<Integer> ansCity = new ArrayList<>();
		ArrayList<Integer>[] road = new ArrayList[N + 1];
		boolean visited[] = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// A -> B
			if (road[A] == null)
				road[A] = new ArrayList<>();
			road[A].add(B);
		}

		// 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중 최단 거리가 정확히 K인 도시들의 번호
		PriorityQueue<City> q = new PriorityQueue<>();
		q.offer(new City(X, 0));
		
		while (!q.isEmpty()) {

			City now = q.poll();

			if (visited[now.num])
				continue;
			visited[now.num] = true;
			
			if (now.dist == K)
				ansCity.add(now.num);
			else if (now.dist < K) {
				if (road[now.num] != null) {
					for (int i = 0; i < road[now.num].size(); i++) {
						if (!visited[road[now.num].get(i)]) {
							q.offer(new City(road[now.num].get(i), now.dist + 1));
						}
					}
				}
			}
		}
		
		if(ansCity.size() == 0)
			answer.append("-1");
		else {
			Collections.sort(ansCity);
			for (int i = 0; i < ansCity.size(); i++) {
				answer.append(ansCity.get(i)).append("\n");
			}
		}

		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
