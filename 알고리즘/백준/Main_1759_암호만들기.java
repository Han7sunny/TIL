import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 1759 12,052kb 76ms
// 문자들을 먼저 정렬한 뒤 문자들의 조합을 구하고 최소 한개의 모음과 최소 두개의 자음으로 구성되어 있을 때 StringBuilder(answer)에 넣어주었습니다.
public class Main_1759_암호만들기 {
	static int L, C;
	static char[] word;
	static boolean[] visited;
	static StringBuilder answer;

	public static void password(int k, int idx, char[] picked, int vowelCnt, int consonantCnt) {
		
		if (k == L) {
			if (vowelCnt >= 1 && consonantCnt >= 2) {
				for (int i = 0; i < L; i++) {
					answer.append(picked[i]);
				}
				answer.append("\n");
			}
			return;
		}
		
		int len = C;
		if(k == 0)
			len = C - L + 1;
		
		for (int i = idx; i < len; i++) {
			if (!visited[i]) {
				picked[k] = word[i];
				visited[i] = true;
				if(word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u')
					password(k+1,i + 1, picked, vowelCnt + 1, consonantCnt); // 모음 
				else
					password(k+1,i + 1, picked, vowelCnt, consonantCnt + 1); // 자음
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		word = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			word[i] = st.nextToken().charAt(0);
		}
		visited = new boolean[C];
		answer = new StringBuilder();
		Arrays.sort(word);
		
		password(0,0, new char[L], 0, 0);
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
