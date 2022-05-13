import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // 1303
	static int n;
	static int m;
	static int wCount;
	static int bCount;
	static int w;
	static int b;
	static Character[][] map;
	static boolean[][] check;
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void power(char color, int x, int y) {
		if(color == 'W')
			wCount++;
		else
			bCount++;
		
		for(int i = 0; i < move.length; i++) {
			int nextX = x + move[i][0];
			int nextY = y + move[i][1];
			if(0 <= nextX && nextX < m && 0 <= nextY && nextY < n) {
				if(!check[nextX][nextY] && map[nextX][nextY] == color) {
					check[nextX][nextY] = true;
					power(color, nextX, nextY);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		w = 0; // 흰색 병사의 위력의 합 (니)
		b = 0; // 파란색 병사의 위력의 합 (적국)
		map = new Character[m][n];
		check = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!check[i][j]) {
					check[i][j] = true;
					if(map[i][j] == 'W')
						wCount = 0;
					else
						bCount = 0;
					
					power(map[i][j], i, j);
					
					if(map[i][j] == 'W')
						w += wCount * wCount;
					else
						b += bCount * bCount;
				}
			}
		}
		br.close();
		bw.write(w + " "+ b + "\n");
		bw.flush();
		bw.close();
	}
}
