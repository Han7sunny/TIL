import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	BOJ_1261 12416kb 100ms
public class Main_1261 {

	public static class Loc implements Comparable<Loc>{

		private int x;
		private int y;
		private int count;

		public Loc(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Loc other) {
			return this.count - other.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Loc> q = new PriorityQueue<>();

		int M = Integer.parseInt(st.nextToken()); // 미로의 가로 크기
		int N = Integer.parseInt(st.nextToken()); // 미로의 세로 길이

		int answer = 0;
		char[][] maze = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		
		// 0 : 빈 방, 1 : 벽
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
		}

		visited[0][0] = true;
		q.add(new Loc(0, 0, 0));

		while (!q.isEmpty()) {

			Loc now = q.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				answer = now.count;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				
				int nx = now.x + move[i][0];
				int ny = now.y + move[i][1];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				
				if(maze[nx][ny] == '0')
					q.add(new Loc(nx, ny, now.count));
				else
					q.add(new Loc(nx, ny, now.count + 1));

			}

		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
