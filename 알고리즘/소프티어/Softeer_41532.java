import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 소프티어_성적 평가
public class Softeer_41532 {

	static int N;

	public static class Info implements Comparable<Info> {
		private int num; // 참가자 번호
		private int score; // 얻은 점수
		
		public Info(int num, int score) {
			this.num = num;
			this.score = score;
		}
		
		public void updateScore(int score) {
			this.score += score;
		}
		
		@Override
		public int compareTo(Info other) {
			return other.score - this.score;
		}
	}

	public static int search(Info[] infoList, int score) {

		int left = 0;
		int right = N - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (infoList[mid].score > score)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left + 1;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 참가자 수
		
		Info[][] infoList = new Info[4][N];
		int[][] grade = new int[4][N]; // 등수
		int[][] gradeByScore = new int[4][3001]; // 점수에 해당하는 등수, 총 점수 최대 3000
		
		for (int i = 0; i < N; i++) {
			infoList[3][i] = new Info(i, 0);
		}

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				
				// 얻은 점수
				infoList[i][j] = new Info(j, Integer.parseInt(st.nextToken()));

				// 총 점수
				infoList[3][j].updateScore(infoList[i][j].score);
			}

		}
		
		//	성적 평가
		for (int i = 0; i < 4; i++) {
			Arrays.sort(infoList[i]);
			for (int j = 0; j < N; j++) {
				if (gradeByScore[i][infoList[i][j].score] == 0)
					gradeByScore[i][infoList[i][j].score] = search(infoList[i], infoList[i][j].score);
				
				grade[i][infoList[i][j].num] = gradeByScore[i][infoList[i][j].score];
			}
		}
		
		//	출력
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				answer.append(grade[i][j]);
				
				//	처리 안 해주면 틀림
                if(j == N - 1) continue;
                answer.append(" ");		
			}
			answer.append("\n");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
