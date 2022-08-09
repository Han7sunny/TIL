import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//SWEA 6808 규영이와 인영이의 카드게임 19,904kb 1,603ms
//재귀 함수로 순열을 구하여 풀었습니다.

public class Solution_6808_규영이와인영이의카드게임 {
	
	static int win;
	static int lose;

	public static void play(int[] my, int[] other, boolean[] visited, int myCount, int otherCount, int k) {
		if (k == 9) {
			if (myCount > otherCount)
				win++;
			else if (myCount < otherCount)
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if(my[k] > other[i])
					play(my, other, visited, myCount + my[k] + other[i], otherCount, k + 1);
				else 
					play(my, other, visited, myCount, otherCount + my[k] + other[i], k + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder answer;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			answer = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			win = 0;
			lose = 0;
			int[] my = new int[9];
			int[] other = new int[9];
			boolean[] check = new boolean[19];
			for (int i = 0; i < 9; i++) {
				my[i] = Integer.parseInt(st.nextToken());
				check[my[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (!check[i])
					other[idx++] = i;
			}
			boolean[] visited = new boolean[9];
			play(my, other, visited, 0, 0, 0);

			answer.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
			bw.write(answer.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
