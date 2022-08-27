import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 17144 미세먼지 안녕! 31,128kb 308ms

public class Main_17144_미세먼지안녕 {

	static int R, C;
	static int[][] dust;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 미세먼지 확산
	public static void dustSpread() {
	    
	    int[][] tempDust = new int[R][C];
	    
	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
	            int dustAmount = dust[i][j] / 5;
	            for (int m = 0; m < 4; m++) {
	                int nextX = i + move[m][0];
	                int nextY = j + move[m][1];
	                
	                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || dust[nextX][nextY] == -1)
	                    continue;
	                
	                tempDust[nextX][nextY] += dustAmount;
	                tempDust[i][j] -= dustAmount;
	            }
	        }
	    }

	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
	            dust[i][j] += tempDust[i][j];
	        }
	    }

	}

	// 공기청정기
	public static void air(int x1, int x2) {

	    Queue<Integer> temp = new ArrayDeque<>();

	    // 위쪽 공기청정기 : 반시계방향
	    temp.offer(dust[x1][C - 1]);
	    for (int i = C - 1; i > 1; i--) {
	        dust[x1][i] = dust[x1][i - 1];
	    }
	    dust[x1][1] = 0;

	    temp.offer(dust[0][C - 1]);
	    for (int i = 0; i < x1; i++) {
	        dust[i][C - 1] = dust[i + 1][C - 1];
	    }
	    dust[x1 - 1][C - 1] = temp.poll();

	    temp.offer(dust[0][0]);
	    for (int i = 0; i + 1 < C; i++) {
	        dust[0][i] = dust[0][i + 1];
	    }
	    dust[0][C - 2] = temp.poll();

	    for (int i = x1 - 1; i > 0; i--) {
	        dust[i][0] = dust[i - 1][0];
	    }
	    dust[1][0] = temp.poll();

	    // 아래쪽 공기청정기 : 시계방향
	    temp.offer(dust[x2][C - 1]);
	    for (int i = C - 1; i > 0; i--) {
	        dust[x2][i] = dust[x2][i - 1];
	    }
	    dust[x2][1] = 0;

	    temp.offer(dust[R - 1][C - 1]);
	    for (int i = R - 1; i > x2; i--) {
	        dust[i][C - 1] = dust[i - 1][C - 1];
	    }
	    dust[x2 + 1][C - 1] = temp.poll();

	    temp.offer(dust[R - 1][0]);
	    for (int i = 0; i < C - 1 ; i++) {
	        dust[R - 1][i] = dust[R - 1][i + 1];
	    }
	    dust[R - 1][C - 2] = temp.poll();

	    for (int i = x2 + 1; i < R - 2; i++) {
	        dust[i][0] = dust[i + 1][0];
	    }
	    dust[R - 2][0] = temp.poll();
	}

	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    int T = Integer.parseInt(st.nextToken()); // T초 후 ...

	    int x1 = 0, x2 = 0;
	    dust = new int[R][C];
	    boolean airLoc = false;
	    int answer = 0;
	    for (int i = 0; i < R; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < C; j++) {
	            dust[i][j] = Integer.parseInt(st.nextToken());
	            if (dust[i][j] == -1 && !airLoc) {
	                x1 = i;
	                x2 = i + 1;
	                airLoc = true;
	            }
	        }
	    }

	    for (int i = 0; i < T; i++) { // T초
	        dustSpread();
	        air(x1, x2);
	    }

	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
	            answer += dust[i][j];
	        }
	    }

	    bw.write(Integer.toString(answer + 2)); // 공기청정기 위치값 -1 -1
	    br.close();
	    bw.flush();
	    bw.close();
	}
	
}