import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main { // 1316
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int answer = n;
		for(int i = 0; i < n; i++) {
			ArrayList<Character> alp = new ArrayList<>();
			String word = br.readLine();
			for(int j = 0; j < word.length(); j++) {
				if(alp.contains(word.charAt(j))) {
					if(word.charAt(j) != word.charAt(j-1)) { // 첫 글자는 alp에 존재하지 않기에 j가 0일 경우 X
						answer--;
						break;
					}
				}
				else
					alp.add(word.charAt(j));
			}
		}
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
