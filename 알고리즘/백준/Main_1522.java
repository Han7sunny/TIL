import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_1522	11592kb	80ms
public class Main_1522 {

	public static void main(String[] args) throws IOException {
		
		// a �������� ����� ���� �ʿ��� �ּ� ��ȯ Ƚ��
		// a ���� ���̸�ŭ Ž���ϸ鼭 �� �ȿ� �ִ� b�� �ּ� ����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] str = br.readLine().toCharArray(); // �ִ� ���� 1000
		int strLen = str.length;
		int answer = 1000; // �ּ� ��ȯ Ƚ��
		int aCnt = 0;

		for (int i = 0; i < strLen; i++) {
			if (str[i] == 'a') {
				aCnt++;
			}
		}

		for (int i = 0; i < strLen; i++) {

			int bCnt = 0;
			for (int j = i; j < i + aCnt; j++) {

				if (str[j % strLen] == 'b')
					bCnt++;

			}

			answer = Math.min(answer, bCnt);
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
