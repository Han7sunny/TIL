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

		int N = Integer.parseInt(br.readLine()); // �ǹ� ����
		
		Stack<Integer> s = new Stack<>();

		int[] height = new int[N + 1]; // �ǹ� ���� �ִ� 10��
		int[] count = new int[N + 1];	//	�� �� �ִ� �ǹ� ���� �ִ� 10��
		int[] near = new int[N + 1];	//	���� ����� �ǹ� ��ȣ (�ּ�)

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			near[i] = N;
		}
		
		// �� -> ��, ���� �ǹ� ���� ���ʿ� ���κ��� ū �ǹ� Ȯ��
		for (int i = 1; i <= N; i++) {
			//	���� �ǹ����� �۰ų� ���� �ǹ� ����
			while(!s.isEmpty() && height[s.peek()] <= height[i]) {
				s.pop();
			}
			
			count[i] = s.size();
			if(!s.isEmpty()) near[i] = s.peek();	//	���� ����� �ǹ� ��ȣ
			s.add(i);
		}

		s = new Stack<>();
		// �� -> ��, ���� �ǹ� ���� �����ʿ� ���κ��� ū �ǹ� Ȯ��
		for (int i = N; i >= 1; i--) {
			while(!s.isEmpty() && height[s.peek()] <= height[i]) {
				s.pop();
			}
			
			count[i] += s.size();
			if(!s.isEmpty() && (Math.abs(i - near[i]) > s.peek() - i))  // near[i]�� i���� ���� ��ȣ, s.peek()�� i���� ū ��ȣ
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
