import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {

//	SWEA 1233 사칙연산 유효성 검사 20,948kb 118ms
//	배열을 사용하였으며 자식이 있을 경우 해당 정점에 숫자가 올 수 없고, 자식이 없을 경우 연산자가 올 수 없습니다.

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] tree = new String[N + 1];
			int answer = 1; // 불가능
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int position = Integer.parseInt(st.nextToken());
				String now = st.nextToken();
				tree[position] = now;
			}
			for (int i = 1; i <= N; i++) {
				
				if(i * 2 > N || i * 2 + 1 > N) { // 자식 X
					if(!('0' <= tree[i].charAt(0) && tree[i].charAt(0) <= '9')) { // 연산자
						answer = 0;
						break;
					}
				}
				else { // 자식 O
					if('0' <= tree[i].charAt(0) && tree[i].charAt(0) <= '9') { // 숫자
						answer = 0;
						break;
					}
				}

			}
			bw.write("#" + test_case + " " + answer + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
