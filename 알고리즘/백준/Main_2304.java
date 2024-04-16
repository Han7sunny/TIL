import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//	BOJ_2304	18200kb	244ms
public class Main_2304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 최대 10

		int answer = 0;
		int maxHeight = 0;
		int maxIdx = 0;
		int[][] info = new int[N][2]; // 기둥 위치와 높이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());

			maxHeight = Math.max(maxHeight, info[i][1]); 
		}

		Arrays.sort(info, (i1, i2) -> i1[0] - i2[0]);

		//	오목하게 들어간 부분이 없도록
		//	상승 또는 하강
		
		Stack<Integer> s = new Stack<>();
		s.add(0);

		for (int i = 1; i < N; i++) {

			// 계속 상승해야함
			if (!s.isEmpty() && info[s.peek()][1] <= info[i][1]) {
				answer += (info[i][0] - info[s.peek()][0]) * info[s.peek()][1];
				s.add(i);
				maxIdx = i;
			}

		}
		
		answer += maxHeight;
		
		s.clear();
		s.add(N - 1);
		for (int i = N - 2; i >= maxIdx; i--) {
			if (!s.isEmpty() && info[s.peek()][1] <= info[i][1]) {
				answer += (info[s.peek()][0] - info[i][0]) * info[s.peek()][1];
				s.add(i);
			}

		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
