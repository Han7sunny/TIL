import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//	BOJ_22866	43633kb	632ms
public class Main_22866 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 건물 개수
		
		Stack<Integer> s = new Stack<>();

		int[] height = new int[N + 1]; // 건물 높이 최대 10만
		int[] count = new int[N + 1];	//	볼 수 있는 건물 개수 최대 10만
		int[] near = new int[N + 1];	//	가장 가까운 건물 번호 (최소)

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			near[i] = N;
		}
		
		// 왼 -> 오, 현재 건물 기준 왼쪽에 본인보다 큰 건물 확인
		for (int i = 1; i <= N; i++) {
			//	현재 건물보다 작거나 같은 건물 제거
			while(!s.isEmpty() && height[s.peek()] <= height[i]) {
				s.pop();
			}
			
			count[i] = s.size();
			if(!s.isEmpty()) near[i] = s.peek();	//	가장 가까운 건물 번호
			s.add(i);
		}

		s = new Stack<>();
		// 오 -> 왼, 현재 건물 기준 오른쪽에 본인보다 큰 건물 확인
		for (int i = N; i >= 1; i--) {
			while(!s.isEmpty() && height[s.peek()] <= height[i]) {
				s.pop();
			}
			
			count[i] += s.size();
			if(!s.isEmpty() && (Math.abs(i - near[i]) > s.peek() - i))  // near[i]는 i보다 작은 번호, s.peek()은 i보다 큰 번호
				near[i] = s.peek();
			s.add(i);
		}
		
		for (int i = 1; i <= N; i++) {
			answer.append(count[i]);
			if(count[i] > 0)
				answer.append(" ").append(near[i]);
			answer.append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
