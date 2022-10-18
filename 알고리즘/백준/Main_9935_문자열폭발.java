import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// BOJ 9935 86560kb 468ms
public class Main_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		String explore = br.readLine(); // 같은 문자 두 개 이상 포함 X

		int len = input.length(); // 최대 100만
		int exploreLen = explore.length(); // 최대 36

		Stack<Character> s = new Stack<>();

		for (int i = 0; i < len; i++) {
			s.push(input.charAt(i));
			if (s.size() >= exploreLen) {
				boolean check = false;
				for (int j = 0; j < exploreLen; j++) { // stack이니까 뒤에서 확인
					if(explore.charAt(exploreLen - 1 - j) != s.get(s.size() - 1 - j)) {
						check = true;
						break;
					}
				}
				
				if(!check) {
					for (int j = 0; j < exploreLen; j++) {
						s.pop();
					}
				}
					
			}
		}
		
		if (s.isEmpty())
			bw.write("FRULA");
		else {
			StringBuilder answer = new StringBuilder();
			while (!s.isEmpty()) {
				answer.append(s.pop());
			}
			bw.write(answer.reverse().toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
}