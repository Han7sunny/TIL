import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ 17406 배열 돌리기 4 37,180kb 356ms
//회전 연산의 순열을 구하고 배열 회전 후 최소값과 비교, 그 이후 *배열 초기화*를 통해 문제를 풀었습니다.
public class Main_17406_배열돌리기4 {
	static int answer = 5001;
	static int N,M,K;
	static int[][] orgArr;
	static int[][] arr;
	static int[][] move = {{0,-1},{-1,0},{0,1},{1,0}};
	static int[][] cal;
	static int[] permCal;
	public static void perm(boolean[] visited, int k) { // 순열
		if(k == K) {
			
			// 뽑은대로 계산하고
			for (int i = 0; i < K; i++) {
				spin(cal[permCal[i]][0], cal[permCal[i]][1], cal[permCal[i]][2]);
			}
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				answer = Math.min(answer, sum);
			}
			
			for(int i = 0; i < N; i++){ // 배열 초기화
				System.arraycopy(orgArr[i], 0, arr[i], 0, M);
			}
			
			return;
		}
		for (int i = 0; i < K; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permCal[k] = i;
				perm(visited, k+1);
				visited[i] = false;
			}	
		}
	}
	
	public static void spin(int r, int c, int s) {
		
		for (int sp = 0; sp < s; sp++) { 
			
			int dir = 0;
			Queue<Integer> temp = new ArrayDeque<>();
			Queue<int[]> start = new ArrayDeque<>();
			start.add(new int[] {r-s+sp,c+s-sp});
			start.add(new int[] {r+s-sp,c+s-sp});
			start.add(new int[] {r+s-sp,c-s+sp});
			start.add(new int[] {r-s+sp,c-s+sp});			
			
			while(!start.isEmpty()) {
				
				int[] startP = start.poll();
				int idx;
				int x = startP[0]; // startX
				int y = startP[1]; // startY

				if(dir != 3)
					temp.add(arr[x][y]);
				
				if(dir <= 1)
					idx = -1;
				else
					idx = 1;
								
				int nextX = x;
				int nextY = y;
				
				if(move[dir][0] != 0) // x가 0이 아니면 x만 값이 변함
					nextX += idx;
				else
					nextY += idx;
								
				int cnt = 1;
				
				while(true) {

					if(move[dir][0] != 0) // x가 0이 아니면 x만 값이 변함
						nextX = x + idx;
					else
						nextY = y + idx;
					
					if(2*s - 2*sp == cnt) {
						if(dir == 0)
							arr[x][y] = arr[nextX][nextY];
						else
							arr[x][y] = temp.poll();
						break;
					}
					else
						arr[x][y] = arr[nextX][nextY];
					
					x = nextX;
					y = nextY;
					cnt++;
				}
				dir++;
			}
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수
		orgArr = new int[N][M];
		arr = new int[N][M];
		cal = new int[K][3]; // 회전 연산 정보
		permCal = new int[K];
		boolean[] visited = new boolean[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				orgArr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = orgArr[i][j];
			}
		}
		
		for (int i = 0; i < K; i++) { // 이 부분 순열로
			st = new StringTokenizer(br.readLine());
			cal[i][0] = Integer.parseInt(st.nextToken()) - 1;
			cal[i][1] = Integer.parseInt(st.nextToken()) - 1;
			cal[i][2] = Integer.parseInt(st.nextToken());
		}
		
		perm(visited,0);
		
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
