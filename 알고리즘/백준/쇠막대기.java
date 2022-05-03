import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class Main { // 10799
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String arrange = br.readLine();
		Stack<Character> s = new Stack<>();
		int answer = 0;
		int stick = 0; // 현재 막대기 개수
		int idx = 0;
		while(idx < arrange.length()) {
			if(arrange.charAt(idx) == '(') {
				if(arrange.charAt(idx + 1) == ')') { // 레이저
					answer += stick;
					idx++; // idx + 2
				}
				else {
					s.add('(');
					stick++;
				}
			}else { // ')'
				if(s.peek() == '(') { // 가장 위에 위치한 막대 끝남
					s.pop();
					stick--;
					answer++;
				}
			}
			idx++;
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
