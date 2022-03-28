import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로 // y
		int N = Integer.parseInt(st.nextToken()); // 세로 // x
		int H = Integer.parseInt(st.nextToken()); // 높이
		int[][][] tomato = new int[H][N][M];
		int[][] loc = new int[][] {{-1,0,0},{1,0,0},{0,0,-1},{0,0,1},{0,1,0},{0,-1,0}};
			// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
		int zeroCnt = 0;
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k] == 0)
						zeroCnt++;
					else if(tomato[i][j][k] == 1)
						q.add(new int[] {i,j,k,0});
				}
			}
		}
    
		if(zeroCnt == 0)
			bw.write(0 + "\n");
		else {
      while(!q.isEmpty()) {
        int[] now = q.poll();
        answer = now[3];
        for(int i = 0; i < loc.length; i++) {
          int h = now[0] + loc[i][0];
          int x = now[1] + loc[i][1];
          int y = now[2] + loc[i][2];
          if(0 <= h && h < H && 0 <= x && x < N && 0 <= y && y < M) {
            if(tomato[h][x][y] == 0) {	
              tomato[h][x][y] = 1;
              zeroCnt--;
              q.add(new int[] {h,x,y,now[3]+1}); // 1
            }
          }
        }
      }
      
      if(zeroCnt == 0) // 0이 모두 1이 되었으면
        bw.write(answer +"\n");
      else
        bw.write(-1 + "\n"); // 모두 익지 못하는 상황
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
