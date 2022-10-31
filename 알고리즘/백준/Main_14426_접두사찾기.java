import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ 14426 114036kb 384ms
public class Main_14426_접두사찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<String>[] S = new ArrayList[26]; // a-z : 26개

		for (int i = 0; i < N; i++) {
			String inputS = br.readLine();
			int idx = inputS.charAt(0) - '0' - 49;
			if (S[idx] == null)
				S[idx] = new ArrayList<>();
			S[idx].add(inputS);
		}

		for (int i = 0; i < M; i++) {
			String prefix = br.readLine();
			int idx = prefix.charAt(0) - '0' - 49;
			if (S[idx] != null) {
				for (int j = 0; j < S[idx].size(); j++) {
					if (S[idx].get(j).substring(0, prefix.length()).equals(prefix)) {
						count++;
						break;
					}
				}
			}
		}

		bw.write(Integer.toString(count));
		br.close();
		bw.flush();
		bw.close();
	}
}
