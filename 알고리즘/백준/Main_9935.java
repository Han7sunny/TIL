import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


//	https://www.acmicpc.net/problem/9935
//	BOJ_9935 89412kb 444ms
public class Main_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		
		Stack<Character> s = new Stack<>();

		char[] str = br.readLine().toCharArray();
		char[] explore = br.readLine().toCharArray();
		
		int strLen = str.length;
		int exploreLen = explore.length;
		
		for (int i = 0; i < strLen; i++) {
			s.push(str[i]);
			
			if(s.size() >= exploreLen) {
				boolean isExplore = true;
				for (int j = 0; j < exploreLen; j++) {
					if(explore[exploreLen - 1 - j] != s.get(s.size() - 1 - j)) {
						isExplore = false;
						break;
					}
				}
				
				if(isExplore) {
					for (int j = 0; j < exploreLen; j++) {
						s.pop();
					}
				}
				
			}
			
		}
		
		if(s.isEmpty()) {
			answer.append("FRULA");
		}
		else {
			while(!s.isEmpty()) {
				answer.append(s.pop());
			}
			answer.reverse();
		}
		
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
