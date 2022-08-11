import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//BOJ 2961 도영이가 만든 맛있는 음식 14,180kb 124ms
//조합으로 풀었습니다.
public class Main_2961_도영이가만든맛있는음식 {
	static int N;
	static int[] S;
	static int[] B;
	static int answer = Integer.MAX_VALUE;
	public static void dish(int s, int b, int k) {
		
		for (int i = k; i < N; i++) {
			int ss = s * S[i];
			int bb = b + B[i];
			if(Math.abs(ss - bb) < answer)
				answer = Math.abs(ss - bb);
			dish(ss, bb, i + 1);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		// 신맛과 쓴맛의 차이가 가장 작은 요리
		dish(1,0,0);
		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

}
