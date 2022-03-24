import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] x = new int[] {-2,-2,-1,1,2,2,-1,1};
	static int[] y = new int[] {-1,1,2,2,-1,1,-2,-2};
	static boolean[][] chess;
	public static int bfs(int startX, int startY, int desX, int desY) {
		Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {startX, startY, 0}); // 현재 위치, 이동 횟수
			while(!q.isEmpty()) {
				int[] now = q.poll();
				if(now[0] == desX && now[1] == desY) {
					return now[2];
				}
				for(int j = 0; j < x.length; j++) {
					int nextX = now[0] + x[j];
					int nextY = now[1] + y[j];

					if(0 <= nextX && nextX < chess.length && 0 <= nextY && nextY < chess.length) {
						if(!chess[nextX][nextY]) {
						    chess[nextX][nextY]=true;
						    q.add(new int[] {nextX, nextY, now[2] + 1});
						}
					}
				}
			}
			return 0;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st;
		int caseNumber = Integer.parseInt(br.readLine());
		for(int i = 0; i < caseNumber; i++) {
			int l = Integer.parseInt(br.readLine());
			chess = new boolean[l][l];
			st = new StringTokenizer(br.readLine());
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());

			bw.write(bfs(nowX, nowY, desX, desY) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
