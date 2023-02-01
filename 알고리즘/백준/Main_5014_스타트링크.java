import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 5014 32092kb 180ms
public class Main_5014_스타트링크 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken()); // 총 F층
		int S = Integer.parseInt(st.nextToken()); // 현재 위치
		int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		int U = Integer.parseInt(st.nextToken()); // 위로 U층
		int D = Integer.parseInt(st.nextToken()); // 아래로 D층

		int maxValue = 1000001;
		int[] floors = new int[F + 1];
		Arrays.fill(floors, maxValue);

		Queue<Integer> floor = new ArrayDeque<>();
		floor.offer(S);
		floors[S] = 0;
		while (!floor.isEmpty()) {
			
			int now = floor.poll();
			
			if (now + U <= F && floors[now] + 1 < floors[now + U]) {
				floors[now + U] = floors[now] + 1;
				floor.add(now + U);
			}

			if (now - D > 0 && floors[now] + 1 < floors[now - D]) {
				floors[now - D] = floors[now] + 1;
				floor.add(now - D);
			}
		}
		
		if (floors[G] == maxValue)
			bw.write("use the stairs");
		else
			bw.write(Integer.toString(floors[G]));
		br.close();
		bw.flush();
		bw.close();

	}

}
