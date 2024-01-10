import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//	BOJ_3190 12184kb 92ms
public class Main_3190 {

	public static class Loc {
		
		private int x;
		private int y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		Map<Integer, String> dirInfo = new HashMap<>();
		Deque<Loc> snake = new ArrayDeque<>();

		int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int answer = 0;
		int locX = 0;
		int locY = 0;
		int dir = 0;
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());	//	사과 개수
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			board[x][y] = 1;	//	사과 위치
		}
		

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			dirInfo.put(s, c);
		}
		

		snake.add(new Loc(locX, locY));	//	시작점

		for (int time = 1; time <= 10000; time++) {

			
			int nx = locX + move[dir][0];
			int ny = locY + move[dir][1];
			
			//	다음 위치
			//	벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
			//	꼬리 줄이기 전, 꼬리와 부딪힐 수 있다.
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == -1) {
				answer = time;
				break;
			}
			
			//	이동한 칸에 사과 없으면, 꼬리가 위치한 칸 비워주기
			if(board[nx][ny] == 0 && !snake.isEmpty()) { 
				Loc tail = snake.poll();
				board[tail.x][tail.y] = 0;	//	꼬리 위치한 칸 비워주기	
			}
			
			snake.add(new Loc(nx, ny));
			
			board[nx][ny] = -1;	//	visited & 사과 없애기
			
			
			//	방향 변환 
			if(dirInfo.containsKey(time)) {
				if(dirInfo.get(time).equals("D")) {
					dir = (dir + 1) % 4;
				}
				else {
					dir = (dir + 4 - 1) % 4;
				}
			}
			
			locX = nx;
			locY = ny;

		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		
	}

}
