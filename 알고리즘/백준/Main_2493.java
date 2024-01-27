import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//	BOJ_2493	107596kb	784ms
public class Main_2493 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> s = new Stack<>();	//	탑 위치(idx) 저장

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] top = new int[N];
		
		for (int i = 0; i < N; i++) {
			
			top[i] = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				s.add(i);
				answer.append(0);
			} else {
				
				while (!s.isEmpty() && top[s.peek()] < top[i]) {
					s.pop();
				}
				answer.append(s.isEmpty() ? 0 : (s.peek() + 1));
				s.add(i);

			}
			if (i < N - 1)
				answer.append(" ");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
