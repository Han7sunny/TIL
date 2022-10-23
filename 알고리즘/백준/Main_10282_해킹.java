import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 10282 156180kb 940ms
public class Main_10282_해킹 {

	static class Virus implements Comparable<Virus> {
		int com1, com2, sec;

		public Virus(int com1, int com2, int sec) {
			super();
			this.com1 = com1;
			this.com2 = com2;
			this.sec = sec;
		}

		@Override
		public int compareTo(Virus v) {
			return this.sec - v.sec;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			PriorityQueue<Virus> q = new PriorityQueue<>();
			int infectComCount = 0;

			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

			ArrayList<Virus>[] com = new ArrayList[n + 1];
			boolean[] infected = new boolean[n + 1];
			int[] time = new int[n + 1];
			Arrays.fill(time, Integer.MAX_VALUE);
			
			q.offer(new Virus(c, c, 0));
			time[c] = 0;
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken()); // s초 후 감염

				if (com[b] == null)
					com[b] = new ArrayList<>();
				com[b].add(new Virus(b, a, s));
			}

			while (!q.isEmpty()) {
				Virus now = q.poll();
				if (infected[now.com2])
					continue;

				infected[now.com2] = true;
				infectComCount++;
				if (com[now.com2] != null) {
					for (int i = 0; i < com[now.com2].size(); i++) {
						Virus nextCom = com[now.com2].get(i);
						if (!infected[nextCom.com2] && time[nextCom.com2] > now.sec + nextCom.sec) {
							time[nextCom.com2] = now.sec + nextCom.sec;
							q.offer(new Virus(now.com2, nextCom.com2, time[nextCom.com2]));
						}
					}
				}
			}

			int totalTime = 0;
			for (int i = 1; i <= n; i++) {
				if (time[i] == Integer.MAX_VALUE)
					continue;
				totalTime = Math.max(totalTime, time[i]);
			}
			answer.append(infectComCount).append(" ").append(totalTime).append("\n");
		}
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
