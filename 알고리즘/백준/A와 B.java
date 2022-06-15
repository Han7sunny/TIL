import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main { // 12904
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuffer s = new StringBuffer(br.readLine()); // 문자열 뒤집기(reverse)를 위하여
		StringBuffer t = new StringBuffer(br.readLine());

		while(s.length() < t.length()) {
			if(t.charAt(t.length() - 1) == 'A')
				t.deleteCharAt(t.length() - 1);
			else if(t.charAt(t.length() - 1) == 'B') {
				t.deleteCharAt(t.length() - 1);
				t.reverse();
			}
		}
		
		if(s.toString().equals(t.toString()))
			bw.write(Integer.toString(1));
		else
			bw.write(Integer.toString(0));

		br.close();
		bw.flush();
		bw.close();
	}
}
