import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// BOJ 3040 백설공주와 일곱 난쟁이 14,328kb 124ms
// 조합으로 문제를 풀었습니다.
// 다른 친구의 풀이 : 두 난쟁이의 키가 (전체 합 - 100)과 동일하다면 두 난쟁이를 제외한 난쟁이들을 출력 -> GOOD
public class Main_3040_백설공주와일곱난쟁이 {
	static int[] hat;
	static int[] little;
	static BufferedWriter bw;
	public static void findLittle(int sum, int k, int idx, int[] little) throws IOException {
		if(k == 7) {
			if(sum == 100) {
				StringBuilder answer = new StringBuilder();
				for (int l : little)
					answer.append(l).append("\n");
				bw.write(answer.toString());

			}
			return;
		}
		
		for (int i = idx; i < 9; i++) {
			if(sum + hat[i] <= 100) {
				little[k] = hat[i];
				findLittle(sum + hat[i], k + 1, i + 1, little);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 100보다 작은 양의 정수, 7의 합이 100
		hat = new int[9];
		little = new int[7];
		for (int i = 0; i < 9; i++) {
			hat[i] = Integer.parseInt(br.readLine());
		}

		findLittle(0,0,0, little);

		br.close();
		bw.flush();
		bw.close();

	}

}
