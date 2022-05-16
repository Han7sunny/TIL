import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int r,c,k;
	static int answer;
	static char[][] map;
	static boolean[][] visited;
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void comeBackHome(int x, int y, int cnt) {
		if(x == 0 && y == c - 1) { // 집(오른쪽 위)
			if(cnt == k)
				answer++;
			return;
		}
					
		for(int i = 0; i < move.length; i++) {
			int nextX = x + move[i][0];
			int nextY = y + move[i][1];				
			if(0 <= nextX && nextX < r && 0 <= nextY && nextY < c) {
				if(map[nextX][nextY] == '.' && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					comeBackHome(nextX, nextY, cnt + 1);
					visited[nextX][nextY] = false; // 핵심 코드
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		answer = 0;
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			String input = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		visited[r-1][0] = true;
		comeBackHome(r-1, 0, 1); // 왼쪽 아래에서 시작
    
		br.close();
    bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
