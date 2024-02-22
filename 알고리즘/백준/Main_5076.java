import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//	BOJ_5076	11408kb	72ms
public class Main_5076 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		
		while(true) {
			
			String input = br.readLine();
			
			if(input.equals("#"))
				break;
			
			Stack<String> s = new Stack<>();
			boolean isLegal = true;
			
			st = new StringTokenizer(input, "<");
			while(st.hasMoreTokens()) {
				String next = st.nextToken();
				
				//	closing tag
				if(next.startsWith("/")) {
					next = next.substring(1, next.indexOf(">"));
					if(!s.isEmpty() && next.equals(s.peek()))
						s.pop();
					else {
						isLegal = false;
						break;
					}
				}
				//	opening & closing
				else if(next.contains("/>")) {
					continue;
				}
				//	opening tag
				else if(next.contains(">")){
					
					// attribute
					if(next.substring(1, next.indexOf(">")).contains(" "))
						next = next.substring(0, next.indexOf(" "));
					else
						next = next.substring(0, next.indexOf(">"));

					s.add(next);
				}
				
			}
			
			if(!s.isEmpty())
				isLegal = false;
			
			answer.append(isLegal ? "legal\n" : "illegal\n");
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		
	}

}
