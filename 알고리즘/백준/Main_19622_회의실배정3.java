import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 19622 49484kb 364ms
public class Main_19622_회의실배정3 {

	static class Meeting implements Comparable<Meeting> {

		int start;
		int end;
		int people;

		public Meeting(int start, int end, int people) {
			this.start = start;
			this.end = end;
			this.people = people;
		}

		@Override
		public int compareTo(Meeting other) {
			return this.end - other.end;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int answer = 0;

		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		int[][] sum = new int[N][2]; // 회의 시간이 겹치지 않는 시간대에 참여한 최대 인원

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(meetings);

		sum[0][1] = meetings[0].people;

		if (N > 1) {

			sum[1][0] = meetings[0].people; // [0] : 현재 회의 선택 X
			sum[1][1] = meetings[1].people; // [1] : 현재 회의 선택 O

			for (int i = 2; i < N; i++) {
				sum[i][0] = Math.max(sum[i - 1][0], sum[i - 1][1]);
				sum[i][1] = Math.max(sum[i - 1][0], sum[i - 2][1]) + meetings[i].people;
			}
		}
		bw.write(Integer.toString(Math.max(sum[N - 1][0], sum[N - 1][1])));
		br.close();
		bw.flush();
		bw.close();

	}

}
