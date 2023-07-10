import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_17609 44708kb 280ms
public class Main_17609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			char[] alp = br.readLine().toCharArray();
			boolean isString = false;
			boolean isDeleted = false;
			boolean isPseudo = false;

			int start = 0;
			int end = alp.length - 1;
			while (start <= end) {
				if (alp[start] == alp[end]) {
					start++;
					end--;
				} else { // 두 포인터가 가리키는 값 다름
					
					if (!isDeleted) {
						
						int s = start;
						int e = end;
						
						if (alp[s + 1] == alp[e]) {
							isDeleted = true;
							s++;
							
							// 나머지 값들이 회문인지 확인해야함
							while (s <= e) {
								if (alp[s] == alp[e]) {
									s++;
									e--;
								} else if (isDeleted) {
									isString = true;
									break;
								}

							}
							
							if(!isString){
								isPseudo = true;
								break;
							}
						}
						
						s = start;
						e = end;
						isString = false;
						
						if (alp[s] == alp[e - 1]) {
							isDeleted = true;
							e--;
							
							// 나머지 값들이 회문인지 확인해야함
							while (s <= e) {
								if (alp[s] == alp[e]) {
									s++;
									e--;
								} else if (isDeleted) {
									isString = true;
									break;
								}

							}
							
							if(!isString){
								isPseudo = true;
								break;
							}
							
						}
						
						isString = true;
						break;

					} else {
						// 한 문제 삭제했는데 두 포인터가 가리키는 값 다름
						// 일반 문자열
						isString = true;
						break;
					}
				}

			}
			if (isPseudo)
				answer.append("1");
			else if (isString)
				answer.append("2");
			else
				answer.append("0");

			// 0 회문
			// 1 유사 회문 (한 문자 삭제하면 회문)
			// 2 그 외 일반 문자열
			answer.append("\n");
		}

		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
