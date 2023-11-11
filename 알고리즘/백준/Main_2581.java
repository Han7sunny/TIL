import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	BOJ_2581 11624kb 80ms
public class Main_2581 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		//	M 이상 N 이하 소수
		boolean[] isPrime = new boolean[N + 1];
		List<Integer> primeList = new ArrayList<>();
		
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false; // 1은 소수가 아니다
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			//	소수면 소수의 배수 제거
			if(isPrime[i]) {
				for (int j = i * 2; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(isPrime[i]) {
				primeList.add(i);
			}
		}
		
		//	소수가 없을 경우 -1
		if(primeList.size() == 0) {
			answer.append("-1");
		}
		else {
			int sum = 0;
			for (int i = 0; i < primeList.size(); i++) {
				sum += primeList.get(i);
			}
			answer.append(sum).append("\n");
			answer.append(primeList.get(0));
		}
		
		br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();
	}

}
