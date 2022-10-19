import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
// BOJ 1389 11852kb 84ms
public class Main_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 100;
		int baconCnt = 100;
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

		int[][] count = new int[N + 1][N + 1];
		ArrayList<Integer>[] friends = new ArrayList[N + 1];

		for (int i = 0; i < M; i++) { // 친구 관계
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (friends[A] == null)
				friends[A] = new ArrayList<>();
			friends[A].add(B);
			count[A][B] = 1;

			if (friends[B] == null)
				friends[B] = new ArrayList<>();
			friends[B].add(A);
			count[B][A] = 1;
		}

		for (int i = 1; i <= N; i++) {
			Arrays.fill(count[i], 100);
		}

		Queue<int[]> q = new ArrayDeque<>();
		for (int user = 1; user <= N; user++) {
			q.offer(new int[] { user, 0 });
			while (!q.isEmpty()) {
				int[] now = q.poll();
				ArrayList<Integer> f = friends[now[0]];
				for (int i = 0; i < f.size(); i++) {
					if (count[user][f.get(i)] > now[1] + 1) {
						count[user][f.get(i)] = now[1] + 1;
						q.offer(new int[] { f.get(i), now[1] + 1 });
					}
				}
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (user != i)
					cnt += count[user][i];
			}
//	            System.out.println("user : "+user+", cnt : "+cnt + ", baconCnt : "+baconCnt +", answer(minUser) " + answer);
			if (baconCnt > cnt) {
				baconCnt = cnt;
				answer = user;
			} else if (baconCnt == cnt)
				answer = Math.min(answer, user);

//	            System.out.println("AFTER user : "+user+", cnt : "+cnt + ", baconCnt : "+baconCnt +", answer(minUser) " + answer +"\n");

		}

		bw.write(Integer.toString(answer)); // 케빈 베이컨의 수가 가장 작은 사람 , 여러 명일 경우 번호가 가장 작은 사람
		br.close();
		bw.flush();
		bw.close();
	}
}
