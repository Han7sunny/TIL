import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//BOJ 10971 외판원 순회2 14,780kb 556ms
//모든 도시들을 시작점으로 두고 탐색을 했을 때 모든 도시들을 탐색하고 마지막 도시에서 시작 도시까지 돌아올 수 있다면 누적 비용과 최소 비용을 비교한다.
public class Main_10971_외판원순회2 {
	static int N;
	static boolean[] visited;
	static long answer = Long.MAX_VALUE;
	static ArrayList<Node>[] nodeList;

	static class Node implements Comparable<Node> {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void travelRoute(int start, int now, int sum, int cnt) {
		if(cnt == N) { // 모든 도시 방문
			for (int i = 0; i < nodeList[now].size(); i++) {
				if(nodeList[now].get(i).vertex == start) {
					sum += nodeList[now].get(i).weight;
					answer = Math.min(answer, sum);
				}
			}
			return;
		}
		
		for (int i = 0; i < nodeList[now].size(); i++) {
			Node next = nodeList[now].get(i);
			if(!visited[next.vertex]) {
				visited[next.vertex] = true;
				travelRoute(start, next.vertex, sum + next.weight ,cnt + 1);
				visited[next.vertex] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine()); // 도시의 수
		StringTokenizer st;

		nodeList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int weight = Integer.parseInt(st.nextToken());
				if (weight != 0) {
					if (nodeList[i] == null)
						nodeList[i] = new ArrayList<>();
					nodeList[i].add(new Node(j, weight));
					if (j == N - 1)
						Collections.sort(nodeList[i]);
				}
			}
		}

		for (int start = 0; start < N; start++) { // 시작점
			visited = new boolean[N];
			visited[start] = true;
			travelRoute(start, start, 0,1);
		}

		bw.write(Long.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
