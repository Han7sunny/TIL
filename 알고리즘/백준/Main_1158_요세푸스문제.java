import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
//	BOJ 1158 요세푸스 문제 14424kb 144ms
//	처음에 Deque를 사용하여 풀었으나 poll한 값을 다시 offer하기를 반복하여 293888kb가 나왔습니다.
//	ArrayList와 index값을 사용하여 풀었습니다.
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> circle = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			circle.add(i);
		}
		StringBuilder answer = new StringBuilder();
		answer.append("<");
		int idx = K - 1;
		while(!circle.isEmpty()) {
			int now = circle.remove(idx);
			answer.append(now);
			if(!circle.isEmpty()) {
				idx += K - 1;
				while(idx >= circle.size())
					idx %= circle.size();
				answer.append(", ");
			}
		}
		answer.append(">");
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
