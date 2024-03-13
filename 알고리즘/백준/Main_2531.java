import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_2531	16532kb	144ms
public class Main_2531 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] dish = new int[d + 1]; // 초밥 종류의 개수
		int[] sushi = new int[N + k]; // 회전 초밥 벨트에 놓인 접시 종류
		int[] count = new int[N + k]; // 현재까지 다른 초밥 개수

		int answer = 0;

		for (int i = 1; i <= N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if (i < k) {
				sushi[i + N] = sushi[i];
			}
		}

		for (int i = 1; i < N + k; i++) {

			dish[sushi[i]]++;

			if (dish[sushi[i]] == 1) {
				if(i < k)
					count[k]++;
				else
					count[i]++;
			}

			if (i < k)
				continue;

			// 연속 k개 완성 i == k

			if (dish[c] == 0)
				count[i]++;

			answer = Math.max(answer, count[i]);

			if(dish[c] == 0)
				count[i]--;
			
			if(i == N + k - 1)
				break;
			
			count[i + 1] = count[i];

			dish[sushi[i - k + 1]]--;
			if (dish[sushi[i - k + 1]] == 0)
				count[i + 1]--;
			

		}

		// 최대한 많은 초밥을 먹을 수 있는 가짓수

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
