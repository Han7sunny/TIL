import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//	BOJ_2234	12088kb	96ms
public class Main_2234 {
	
	static int[][] move = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int[][] board;
	static int[][] room;
	
	public static int dfs(int x, int y, int num) {
		int sum = 1;
		room[x][y] = num;
		
		for (int i = 0; i < 4; i++) {
			if((board[x][y] & (1 << i)) != 0 || room[x + move[i][0]][y + move[i][1]] > 0) continue;
			sum += dfs(x + move[i][0], y + move[i][1], num);
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[M][N];
		room = new int[M][N];	//	성에 있는 방 번호
		List<Integer> size = new ArrayList<>();
		size.add(0);
		
		int count = 0;	//	성에 있는 방의 개수
		int sum = 0;	//	가장 넓은 방의 넓이
		int max = 0;	//	하나의 벽 제거하여 얻을 수 있는 가장 넓은 방의 크기			
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//	성에 있는 방의 개수, 가장 넓은 방의 넓이 구하기
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(room[i][j] == 0) {
					count++;
					size.add(dfs(i, j, count));
					sum = Math.max(sum, size.get(count));
				}
			}
		}
		
		//	벽 사이로 방 번호 다르면 두개 합친 값 최대
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				for (int k = 0; k < 4; k++) {
					if(((board[x][y]) & (1 << k)) == 0) continue;
					int nx = x + move[k][0];
					int ny = y + move[k][1];
					if(nx < 0 || ny < 0 || nx >= M || ny >= N || room[x][y] == room[nx][ny]) continue;
					max = Math.max(max, size.get(room[x][y]) + size.get(room[nx][ny]));
				}
			}
		}
		
		
		answer.append(count).append("\n");
		answer.append(sum).append("\n");
		answer.append(max);
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
