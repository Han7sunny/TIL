import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_1926_그림 {
	static int n,m;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int[][] picture;
	
	static class Loc {
		int x;
		int y;

		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int count(int x, int y) {
		
		int totalCnt = 0;
		Queue<Loc> q = new ArrayDeque<>();
		q.offer(new Loc(x,y));
		picture[x][y] =	0;
		
		while(!q.isEmpty()) {
			Loc now = q.poll();
			totalCnt++;
			
			for (int i = 0; i <4; i++) {
				int nx = now.x + move[i][0];
				int ny = now.y + move[i][1];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || picture[nx][ny] == 0)
					continue;

				picture[nx][ny] = 0;
				q.offer(new Loc( nx, ny ));
			}
		}
		return totalCnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int largest = 0;
		picture = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(picture[i][j] == 1) {
					cnt++;
					largest = Math.max(largest, count(i,j));
				}
			}
		}
		answer.append(cnt).append("\n").append(largest);
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
