import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

//	BOJ_1941	15548kb	348ms
public class Main_1941 {

	static int answer;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static int[][] board;

	public static void comb(int k, int idx, int picked, int[] bucket) {

		if (k == 7) {
			
			// ���� ���γ� ���η� ������ �ִ��� Ȯ��

			picked ^= (1 << bucket[0]);
			q.add(bucket[0]);

			while (!q.isEmpty()) {

				int now = q.poll();
				k--;

				for (int i = 0; i < 4; i++) {

					int nx = now / 5 + move[i][0];
					int ny = now % 5 + move[i][1];

					if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (picked & 1 << (nx * 5 + ny)) == 0)
						continue;

					picked ^= (1 << (nx * 5 + ny));
					q.add(nx * 5 + ny);
				}

			}

			//	���� ������ ��� S�� ��� 4�� �̻����� Ȯ��
			//	S = 1, Y = -1
			if (k == 0) {
				for (int i = 0; i < 7; i++) {
					k += board[bucket[i] / 5][bucket[i] % 5];
				}

				if (k >= 1)
					answer++;
			}
			
			return;
		}

		for (int i = idx; i < 25; i++) {
			if ((picked & (1 << i)) == 0) {
				bucket[k] = i;
				comb(k + 1, i + 1, picked | (1 << i), bucket);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0; j < 5; j++) {
				board[i][j] = input.charAt(j) == 'S' ? 1 : -1;
			}
		}

		// ����
		// 25 �� 7�� �̰�
		// �ش� ���ڸ� 5*5 �迭�� �ε����� ��ȯ
		// �ش� �迭�� ���� 1 �̻��� ��� answer++
		comb(0, 0, 0, new int[7]);
	
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
