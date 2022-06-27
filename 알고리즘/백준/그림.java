import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main { // 1926
	static int n,m;
	static int[][] paint;
	static int[][] move = {{0,-1},{0,1},{-1,0},{1,0}};
	public static int checkSize(int x, int y, int size) {
		paint[x][y] = 0;
		int total = 1;
		for(int i = 0; i < move.length; i++) {
			int nextX = x + move[i][0];
			int nextY = y + move[i][1];
			if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m) {
				if(paint[nextX][nextY] == 1) {
					total += checkSize(nextX, nextY, size + 1);
				}
			}
		}
		return total;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paint = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				paint[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int paintCount = 0;
		int paintSize = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(paint[i][j] == 1) {
					paintSize = Math.max(paintSize,checkSize(i,j,0));
					paintCount++;
				}
			}
		}
		br.close();
		bw.write(paintCount + "\n");
		bw.write(paintSize + "\n");
		bw.flush();
		bw.close();
	}
}
