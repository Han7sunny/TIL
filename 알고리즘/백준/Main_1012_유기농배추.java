import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {

	static int N,M;
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	public static void search(int x, int y) {
		map[x][y] = 0; // 배추 지우기
		
		int nextX, nextY;
		for (int i = 0; i < 4; i++) {
			nextX = x + move[i][0];	
			nextY = y + move[i][1];	
			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
				continue;
			if(map[nextX][nextY] == 1)
				search(nextX, nextY);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추 개수
			map = new int[M][N];
			int count = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1; // 배추 
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						search(i,j);
						count++;
					}
				}
			}
			answer.append(count).append("\n");
		}
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}