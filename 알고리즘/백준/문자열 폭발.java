import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class Main { // 9935
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String input = br.readLine();
		String explore = br.readLine();
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < input.length(); i++) {
			s.push(input.charAt(i));
			if(s.size() >= explore.length()) { // while 느낌		
				boolean check = true;
				for(int j = 0; j < explore.length(); j++) {
					if(s.get(s.size() - explore.length() + j) != explore.charAt(j)) {
						check = false;
						break;
					}
				}
				if(check) {
					for(int j = 0; j < explore.length(); j++)
						s.pop();
				}
			}
			
		}
		
		if(s.isEmpty())
			bw.write("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < s.size(); i++)
				sb.append(s.get(i));
			bw.write(sb.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
