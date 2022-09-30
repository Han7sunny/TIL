import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 17070 파이프 옮기기 25,672kb 404ms
// DFS로 풀었습니다...^^DP로 다시 풀어볼게요
public class Main_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int count = 0;
	public static boolean checkRight(int x, int y) {
		if(x + 1 < N && map[x+1][y] == 0)
			return true;
		return false;
	}
	public static boolean checkDown(int x, int y) {
		if(y + 1 < N && map[x][y+1] == 0)
			return true;
		return false;
	}
	public static boolean checkDownCross(int x, int y) {
		if(checkRight(x,y) && checkDown(x, y) && map[x+1][y+1] == 0)
			return true;
		return false;
	}
	public static void countPipe(int x1, int y1, int x2, int y2) {
		
		if(x2 == N -1 && y2 == N - 1) {
			count++;
			return;
		}
		
		if(y1 == y2) { // 가로
			if(checkRight(x2, y2)) countPipe(x2,y2,x2+1,y2);
			if(checkDownCross(x2, y2)) countPipe(x2,y2,x2+1,y2+1);
		} else if(x1 == x2) {// 세로
			if(checkDown(x2, y2)) countPipe(x2,y2,x2,y2+1);
			if(checkDownCross(x2, y2)) countPipe(x2,y2,x2+1,y2+1);
		}
		else { // 대각선
			if(checkRight(x2, y2)) countPipe(x2,y2,x2+1,y2);
			if(checkDown(x2, y2)) countPipe(x2,y2,x2,y2+1);
			if(checkDownCross(x2, y2)) countPipe(x2,y2,x2+1,y2+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// int[][] location = { { 0, 0 }, { 0, 1 } }; // end, start
		// 경우의 수 :
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		countPipe(0, 0, 0, 1);
		bw.write(Integer.toString(count));
		br.close();
		bw.flush();
		bw.close();
	}

}
