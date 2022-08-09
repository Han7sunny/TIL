import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//SWEA 1861 정사각형 방 29,848kb 436ms
//DFS로 사방탐색을 하며 풀었습니다.
public class Solution_1861_정사각형방 {
	
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static int answerCount, answerRoom; // 최대값
	static boolean[][] visited;
	static int[][] room;
	public static void roomVisit(int x, int y, int startRoom, int count) {
		
		visited[x][y] = true;
		
		int nextX;
		int nextY;
		for (int i = 0; i < 4; i++) {
			nextX = x + move[i][0];
			nextY = y + move[i][1];
			if(0 <= nextX && nextX < N && 0 <= nextY && nextY < N) {
				if(room[x][y] + 1 == room[nextX][nextY] && !visited[nextX][nextY]) {
					roomVisit(nextX, nextY, startRoom, count + 1);
				}
			}
		}
		if(answerCount <= count) {
			answerCount = count;
			if(answerCount == count)
				answerRoom = Math.min(startRoom, answerRoom);
			else
				answerRoom = startRoom;
		}
		visited[x][y] = false;
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder result;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			result = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			visited = new boolean[N][N];
			answerCount = 0;
			answerRoom = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken()); // 숫자가 다 달라
				}
			}
			
			// 지금 방보다 1 커야함
			// DFS

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					roomVisit(i, j, room[i][j], 1);
				}
			}
			result.append("#").append(test_case).append(" ").append(answerRoom).append(" ").append(answerCount).append("\n");
			bw.write(result.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
}
