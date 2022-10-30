import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 1992 46120kb 504ms kruskal
public class Main_1922_네트워크연결 {

	static Node[] nodeList;
	static int[] parents;
	static int N, M;

	static class Node implements Comparable<Node> {

		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}

	}

	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) { // a의 부모 찾기
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int answer = 0;
		int count = 0;

		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수
		nodeList = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // a 컴퓨터와 b 컴퓨터를 연결하는 비용
			nodeList[i] = new Node(a, b, c);
		}

		make();
		Arrays.sort(nodeList);

		for (Node node : nodeList) {
			if (union(node.from, node.to)) {
				answer += node.cost;
				if (++count == N - 1)
					break;
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
