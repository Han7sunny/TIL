import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//	BOJ_2412	44708kb	840ms
public class Main_2412 {

	public static class Info {

		private int x;
		private int y;
		private int count;

		public Info(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int MAX = 200000;
		Queue<Info> q = new ArrayDeque<>();
		List<Integer>[] list = new ArrayList[MAX + 1];

		int answer = MAX;

		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); // y가 T가 될 때까지 암벽 오르기

		for (int i = 0; i <= MAX; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[y].add(x);
		}

		for (int i = 0; i <= MAX; i++) {
			Collections.sort(list[i], Collections.reverseOrder()); // 뒤에서부터 삭제하기 위해 내림차순 정렬
		}

		q.add(new Info(0, 0, 0));

		while (!q.isEmpty()) {

			Info now = q.poll();

			if (now.y == T) {
				answer = now.count;
				break;
			}

			for (int y = now.y - 2; y <= now.y + 2; y++) {
				
				if (y < 0 || y > MAX)
					continue;
				
				for (int j = list[y].size() - 1; j >= 0; j--) {
					
					if(now.x + 2 < list[y].get(j)) break;
					else if(now.x - 2 > list[y].get(j)) continue;
					
					q.add(new Info(list[y].get(j), y, now.count + 1));
					list[y].remove(j);
				}
			}

		}

		br.close();
		bw.write(Integer.toString(answer == MAX ? -1 : answer));
		bw.flush();
		bw.close();

	}

}
