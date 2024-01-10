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
		
		int K = Integer.parseInt(br.readLine());	//	��� ����
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			board[x][y] = 1;	//	��� ��ġ
		}
		

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			
			dirInfo.put(s, c);
		}
		

		snake.add(new Loc(locX, locY));	//	������

		for (int time = 1; time <= 10000; time++) {

			
			int nx = locX + move[dir][0];
			int ny = locY + move[dir][1];
			
			//	���� ��ġ
			//	���̳� �ڱ��ڽ��� ���� �ε����� ������ ������.
			//	���� ���̱� ��, ������ �ε��� �� �ִ�.
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == -1) {
				answer = time;
				break;
			}
			
			//	�̵��� ĭ�� ��� ������, ������ ��ġ�� ĭ ����ֱ�
			if(board[nx][ny] == 0 && !snake.isEmpty()) { 
				Loc tail = snake.poll();
				board[tail.x][tail.y] = 0;	//	���� ��ġ�� ĭ ����ֱ�	
			}
			
			snake.add(new Loc(nx, ny));
			
			board[nx][ny] = -1;	//	visited & ��� ���ֱ�
			
			
			//	���� ��ȯ 
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
