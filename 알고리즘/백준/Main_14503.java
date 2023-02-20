import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BOJ 14503 11924kb 84ms
public class Main_14503 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;

		// 방의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		// 처음 로봇 청소기 좌표
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 바라보는 방향 (0:북, 1:동, 2:남, 3:서)
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 0 : 청소되지 않은 칸, 1 : 벽
			// 로봇 청소기는 항상 빈 칸에 위치
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사방 탐색
		int[][] fourWay = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
		
		// (0:북, 1:동, 2:남, 3:서)
		int[][] turnAndStraight = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		int[][] backward = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

		while (true) {

			// 1.현재 칸이 아직 청소되지 않은 경우(0), 현재 칸 청소
			if (room[r][c] == 0) {
				room[r][c] = 2; // 청소한 빈 칸
				answer++;
			}
			
			boolean uncleanedRoom = false;
			for (int i = 0; i < 4; i++) {
				int nx = r + fourWay[i][0];
				int ny = c + fourWay[i][1];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸(0)이 있는 경우
				if (room[nx][ny] == 0) {
					uncleanedRoom = true;
					break;
				}
			}
			
			// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸(0)이 없는 경우
			if (!uncleanedRoom) {

				if (r + backward[d][0] < 0 || r + backward[d][0] >= N || c + backward[d][1] < 0
						|| c + backward[d][1] >= M)
					continue;
				
				// 바라보는 방향 유지한 채 한 칸 후진할 수 없다면 작동 멈춤
				if (room[r + backward[d][0]][c + backward[d][1]] == 1)
					break;
				else {
					// 바라보는 방향 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
					r += backward[d][0];
					c += backward[d][1];
				}

			} else {
				// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸(0)이 있는 경우

				if (room[r + turnAndStraight[d][0]][c + turnAndStraight[d][1]] == 0) {
					r += turnAndStraight[d][0];
					c += turnAndStraight[d][1];
				}
				
				// 반시계 방향으로 90도 회전
				// 북 0 -> 서 3
				// 동 1 -> 북 0
				// 남 2 -> 동 1
				// 서 3 -> 남 2
				
				if (d == 0)
					d = 3;
				else
					d -= 1;

			}

		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
