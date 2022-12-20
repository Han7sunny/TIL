import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 3187 16468kb 148ms
public class Main_3187_양치기꿍 {
	
	static int R, C;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visited;

	static class Loc {
		int x;
		int y;

		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[] countAnimals(int x, int y) {

		int[] result = new int[2];
		Queue<Loc> q = new ArrayDeque<>();
		q.offer(new Loc ( x, y ));
		visited[x][y] = true;

		int sheep = 0;
		int wolf = 0;

		while (!q.isEmpty()) {
			Loc now = q.poll();
			if (map[now.x][now.y] == 'k')
				sheep++;
			else if (map[now.x][now.y] == 'v')
				wolf++;
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + move[i][0];
				int ny = now.y + move[i][1];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#' || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				q.offer(new Loc( nx, ny ));
			}
		}
		
		if (sheep > wolf)
			result[0] = sheep;
		else
			result[1] = wolf;

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int sheep = 0;
		int wolf = 0;

		map = new char[R][C];
		visited = new boolean[R][C];

		Queue<Loc> animalLoc = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'v' || map[i][j] == 'k')
					animalLoc.offer(new Loc( i, j ));
			}
		}
		
		while (!animalLoc.isEmpty()) {
			Loc loc = animalLoc.poll();
			if (!visited[loc.x][loc.y]) {
				int[] cnt = countAnimals(loc.x, loc.y);
				sheep += cnt[0];
				wolf += cnt[1];
			}
		}

		bw.write(sheep + " " + wolf + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
