import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
public class Main {
	
	public static void main(String[] args) throws IOException { // 1620
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, String> name = new HashMap<>(); // name -> num
		Map<String, String> number = new HashMap<>(); // num -> name

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] answer = new String[m];

		for(int num = 1; num <= n; num++) {
			String input = br.readLine();
			name.put(input, Integer.toString(num));
			number.put(Integer.toString(num), input);
		}
		
		for(int i = 0; i < m; i++) {
			String input = br.readLine();
			if(Character.isDigit(input.charAt(0)))
				answer[i] = number.get(input);
			else
				answer[i] = name.get(input);
		}
	
		br.close();
		for(int i = 0; i < m; i++)
			bw.write(answer[i] + "\n");
		bw.flush();
		bw.close();
	}
}
