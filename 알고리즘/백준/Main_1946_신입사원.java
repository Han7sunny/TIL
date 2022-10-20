import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 1946 300916kb 1792ms
public class Main_1946_신입사원 {

	static class People implements Comparable<People>{
		int num, score, grade;

		public People(int num, int score, int grade) {
			this.num = num;
			this.score = score;
			this.grade = grade;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		@Override
		public int compareTo(People p) {
			return this.score - p.score;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 20 이하
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine()); // 지원자 숫자 10만 이하
			int count = 0;
			PriorityQueue<People> orderByScore = new PriorityQueue<>();

			for (int i = 0; i < N; i++) { // i : 지원자 번호
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken()); // 지원자의 서류 심사 성적
				int grade = Integer.parseInt(st.nextToken()); // 지원자의 면접 시험 성적 순위 : 1위부터 N위까지 동석차 없이 결정

				People people = new People(i, score, grade);
				orderByScore.offer(people);
			}
			
			int minGrade = orderByScore.poll().grade;
			count++;// 1등 무조건 통과

			while(!orderByScore.isEmpty()) {
				People now = orderByScore.poll();
				// 그 전 최소값보다 
				if(now.grade < minGrade) {
					count++;
					minGrade = now.grade;
				}
			}
			answer.append(count).append("\n");

		}

		bw.write(answer.toString()); // 선발할 수 있는 신입사원의 최대 인원수
		br.close();
		bw.flush();
		bw.close();
	}
}
