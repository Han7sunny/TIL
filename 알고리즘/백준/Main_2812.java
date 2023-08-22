import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//	BOJ_2812 33208kb 392ms
public class Main_2812 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 입력으로 주어진 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수 출력
		
		int size = N - K;
		
		Stack<Integer> s = new Stack<>();

		char[] input = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			int num = input[i] - '0';
			
			while(!s.isEmpty() && s.peek() < num && K > 0) {
				K--;
				s.pop();
			}
			s.push(num);
		}
		
		while(!s.isEmpty()) {
			if(s.size() > size)
				s.pop();
			else
				answer.append(s.pop());
		}
		answer.reverse();

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
