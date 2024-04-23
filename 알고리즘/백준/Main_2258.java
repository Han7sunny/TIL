import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_2258	47768kb	584ms
public class Main_2258 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 덩어리 개수
		int M = Integer.parseInt(st.nextToken()); // 필요한 고기의 양

		int[][] info = new int[N][2];
		int totalWeight = 0;

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()); // 고기 덩어리 무게
			info[i][1] = Integer.parseInt(st.nextToken()); // 고기 덩어리 가격
			totalWeight += info[i][0];
		}

		if (totalWeight < M)
			answer = -1;
		else {
			int wSum = 0;	//	무게 합
			int pSum = 0;	//	가격 합
			int pre = 0;	//	이전 가격
			
			Arrays.sort(info, (i1, i2) -> {
				if (i1[1] == i2[1])
					return Integer.compare(i2[0], i1[0]);
				return Integer.compare(i1[1], i2[1]);
			}); // 고기 덩어리 가격 기준 오름차순 정렬, 가격 동일할 경우 무게 기준 내림차순 정렬
			// 현재 고기보다 가격이 싼 고기들은 개수에 관계없이 추가 비용 지불 없이 얻을 수 있다.
			
			for (int i = 0; i < N; i++) {
				
				if(pre == info[i][1]) {
					pSum += info[i][1];
				}
				else {
					pSum = info[i][1];
					pre = info[i][1];
				}
				
				wSum += info[i][0];
				if (wSum >= M)
					answer = Math.min(answer, pSum);

			}
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
