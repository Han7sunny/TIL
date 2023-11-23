import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	BOJ_1647 324876kb 1448ms
public class Main_1647 {

	static int[] parent;

	public static class Info implements Comparable<Info> {

		private int A;
		private int B;
		private int C;

		public Info(int a, int b, int c) {
			this.A = a;
			this.B = b;
			this.C = c;
		}

		@Override
		public int compareTo(Info other) {
			return this.C - other.C;
		}

	}

	public static void init(int N) {
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {

		if (x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		parent[b] = a;
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Info> pq = new PriorityQueue<>();

		int answer = 0;
		int maxCost = 0;

		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int M = Integer.parseInt(st.nextToken()); // 길의 개수

		init(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // A와 B를 연결하는 길의 유지비

			pq.add(new Info(A, B, C));
		}

		// 모든 집을 하나로 이어주기
		while (!pq.isEmpty()) {

			Info now = pq.poll();

			if (union(now.A, now.B)) {
				answer += now.C;
				maxCost = Math.max(maxCost, now.C);
			}

		}

		// 최대 유지비 삭제하기
		answer -= maxCost;

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

}
