import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_18429	11728kb	92ms
public class Main_18429 {
	
	static int N, K;
	static int[] kit;
	static int answer = 0;
	
	public static void dfs(int sum, int idx, int flag) {
		if(idx == N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & (1 << i)) == 0 && sum + kit[i] - K >= 500) {
				dfs(sum + kit[i] - K, idx + 1, flag | (1 << i));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());	//	� ŰƮ �ִ� 8
		K = Integer.parseInt(st.nextToken());	//	���� �����ϴ� �߷� �ִ� 50
		
		kit = new int[N];
		int sum = 0;
		
		//	N�� ���ı��� �߷� 500 �̻� �����ǵ���
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
			sum += kit[i];
		}
		
		if(sum > K * N) {
			Arrays.sort(kit);
			dfs(500, 0, 0);
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
