import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_20366	12780kb	404ms
public class Main_20366 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] h = new int[N];
		int answer = 987654321;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(h); // 투 포인터를 위한 오름차순 정렬

		if (N == 4) {
			answer = Math.abs(h[0] + h[3] - (h[1] + h[2]));
		} else {
			// elsa
			for (int s1 = 0; s1 < N - 3; s1++) {
				for (int e1 = s1 + 3; e1 < N; e1++) {
					
					//	anna
					int s2 = s1 + 1;
					int e2 = e1 - 1;

					while (s2 < e2) {

						int result = h[s1] + h[e1] - (h[s2] + h[e2]);	//	elsa - anna

						answer = Math.min(answer, Math.abs(result));

						if (result > 0)	//	anna 크기 키우기
							s2++;
						else if (result < 0) //	anna 크기 줄이기
							e2--;
						else //	0
							break;
					}
				}
			}

		}
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

}

//	참고
//  https://velog.io/@pss407/%EB%B0%B1%EC%A4%8020366-%EA%B0%99%EC%9D%B4-%EB%88%88%EC%82%AC%EB%9E%8C-%EB%A7%8C%EB%93%A4%EB%9E%98
