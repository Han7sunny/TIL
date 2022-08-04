import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {

//	SWEA 1218 괄호 짝짓기 18,772kb 101ms
//	Stack과 switch문, if문을 사용하여 풀었습니다.
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			Stack<Character> s = new Stack<>();
			boolean isValid = true;
			int length = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			for(int i = 0; i < length; i++) {
				switch(input[i]) {
					case ')':
						if(s.peek() != '(')
							isValid = false;
						else
							s.pop();
						break;
					case ']':
						if(s.peek() != '[')
							isValid = false;
						else
							s.pop();
						break;	
					case '}':
						if(s.peek() != '{') 
							isValid = false;
						else
							s.pop();
						break;
					case '>':
						if(s.peek() != '<')
							isValid = false;
						else
							s.pop();
						break;
					default:
						s.push(input[i]);
						break;
				}
				if(!isValid)
					break;
			}
			bw.write("#" + test_case + " " + (isValid?1:0) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
