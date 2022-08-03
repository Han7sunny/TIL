
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			String org = br.readLine();
			char bit = '0';

			for (int i = 0; i < org.length(); i++) {
				if (org.charAt(i) != bit) {
					if (bit == '0')
						bit = '1';
					else
						bit = '0';
					answer++;
				}
			}
			bw.write("#" + test_case + " " + answer + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
