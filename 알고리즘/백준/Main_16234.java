import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_16234 297920kb 708ms
public class Main_16234 {


	public static class Loc {
		int r;
		int c;

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // NxN
		int L = Integer.parseInt(st.nextToken()); // 인구 차이 L 이상
		int R = Integer.parseInt(st.nextToken()); // 인구 차이 R 이하

		int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int[][] population = new int[N][N];
		boolean[][] checked;

		int day = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			
			int cnt = 0;
			checked = new boolean[N][N];

			Queue<Loc> q = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!checked[i][j]) {
						
						int sum = 0;
						int movedPopulation = 0;
						Queue<Loc> opened = new ArrayDeque<>();
						q.offer(new Loc(i, j));
						
						while (!q.isEmpty()) {

							Loc now = q.poll();

							int beforeSize = q.size();

							for (int k = 0; k < 4; k++) {

								int nr = now.r + move[k][0];
								int nc = now.c + move[k][1];

								if (nr < 0 || nr >= N || nc < 0 || nc >= N || checked[nr][nc]
										|| Math.abs(population[now.r][now.c] - population[nr][nc]) < L
										|| Math.abs(population[now.r][now.c] - population[nr][nc]) > R)
									continue; 

								sum += population[nr][nc];
								checked[nr][nc] = true;

								Loc open = new Loc(nr, nc);
								q.offer(open);
								opened.offer(open);
							}
														
							if (beforeSize != q.size()) {
								if(!checked[now.r][now.c]) {
									opened.offer(now);
									sum += population[now.r][now.c];
								}
							}

							checked[now.r][now.c] = true;

						}
						
						cnt += opened.size();
						
						if (opened.size() == 0)
							continue;

						movedPopulation = sum / opened.size();
						
						while (!opened.isEmpty()) {
							Loc loc = opened.poll();
							population[loc.r][loc.c] = movedPopulation;
							
						}
												
					}

				}
			}
			
			if(cnt == 0)
				break;
			
			day++;

		}

		br.close();
		bw.write(Integer.toString(day));
		bw.flush();
		bw.close();

	}

}
