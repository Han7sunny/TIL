import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_2294 12052kb 108ms
public class Main_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//	동전 개수
		int K = Integer.parseInt(st.nextToken());	//	동전 가치의 합
		
		int max = 10000000;
		
		int[] won = new int[N];			//	동전의 가치
		int[] price = new int[K + 1];	//	idx 가치를 위한 최소 동전 개수
				
		//	동전의 개수가 최소이면서 가치의 합이 K일 경우의 동전 개수
		for (int i = 0; i < N; i++) {
			won[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(won);
		Arrays.fill(price, max);
		price[0] = 0;
		
		for (int i = 0; i < N; i++) {
			int w = won[i];
			for (int j = w; j <= K; j++) {
				price[j] = Math.min(price[j], price[j - w] + 1);
			}
		}
		
		br.close();
		bw.write(price[K] == max ? "-1" : Integer.toString(price[K]));
		bw.flush();
		bw.close();
	}

}
