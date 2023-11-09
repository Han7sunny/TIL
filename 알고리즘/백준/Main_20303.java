import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	BOJ_20303 564452kb 688kb
public class Main_20303 {

	static int fCount, cCount;
	static int[] candy;
	static boolean[] checked;
	static List<Integer>[] friends;

	public static class Info implements Comparable<Info> {
		int friendCount;
		int candyCount;

		public Info(int friendCount, int candyCount) {
			this.friendCount = friendCount;
			this.candyCount = candyCount;
		}

		@Override
		public int compareTo(Info other) {
			return this.friendCount - other.friendCount;
		}
	}

	public static void stealCandy(int num) {

		fCount++;
		cCount += candy[num];

		for (int n : friends[num]) {
			if (!checked[n]) {
				checked[n] = true;
				stealCandy(n);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // �Ÿ��� �ִ� ���̵��� ��
		int M = Integer.parseInt(st.nextToken()); // ���̵��� ģ�� ���� ��
		int K = Integer.parseInt(st.nextToken()); // �����Ҹ��� �����ϱ� ���� �ּ� ������ ��

		int idx = 1;
		int[][] dp;
		candy = new int[N + 1];
		friends = new ArrayList[N + 1];
		checked = new boolean[N + 1];
		PriorityQueue<Info> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			// �����
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friends[a].add(b);
			friends[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (!checked[i]) {
				// �ο�, ���� ����
				fCount = 0;
				cCount = 0;
				checked[i] = true;
				stealCandy(i);
				
				if(fCount < K) {
					pq.add(new Info(fCount, cCount));
				}
			}
		}
		
		dp = new int[pq.size() + 1][K];
		// �ο��� K�� ���� �����鼭 candy �ִ�
		while (!pq.isEmpty()) {
			
			Info info = pq.poll();
			
			for (int i = info.friendCount; i < K; i++) {
				dp[idx][i] = Math.max(dp[idx - 1][i - info.friendCount] + info.candyCount, dp[idx - 1][i]);
			}
			
			idx++;
		}
		
		br.close();
		bw.write(Integer.toString(dp[dp.length - 1][K - 1]));
		bw.flush();
		bw.close();
	}

}
