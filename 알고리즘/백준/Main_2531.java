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

		int N = Integer.parseInt(st.nextToken()); // ������ ��
		int d = Integer.parseInt(st.nextToken()); // �ʹ��� ������
		int k = Integer.parseInt(st.nextToken()); // �����ؼ� �Դ� ������ ��
		int c = Integer.parseInt(st.nextToken()); // ���� ��ȣ

		int[] dish = new int[d + 1]; // �ʹ� ������ ����
		int[] sushi = new int[N + k]; // ȸ�� �ʹ� ��Ʈ�� ���� ���� ����
		int[] count = new int[N + k]; // ������� �ٸ� �ʹ� ����

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

			// ���� k�� �ϼ� i == k

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

		// �ִ��� ���� �ʹ��� ���� �� �ִ� ������

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
