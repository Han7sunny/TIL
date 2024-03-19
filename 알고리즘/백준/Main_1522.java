import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	BOJ_1522	11592kb	80ms
public class Main_1522 {

	public static void main(String[] args) throws IOException {
		
		// a 연속으로 만들기 위해 필요한 최소 교환 횟수
		// a 연속 길이만큼 탐색하면서 그 안에 있는 b의 최소 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] str = br.readLine().toCharArray(); // 최대 길이 1000
		int strLen = str.length;
		int answer = 1000; // 최소 교환 횟수
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
