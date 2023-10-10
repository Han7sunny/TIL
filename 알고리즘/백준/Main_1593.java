import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_1593 38692kb 228ms
public class Main_1593 {

	static int[] alpCount = new int[123]; // W를 구성하는 알파벳의 개수
	static int[] slideCount = new int[123];	//	startIdx부터 endIdx까지의 알파벳 개수
	static char[] sList;	//	문자열 S 배열

	//	W를 구성하는 알파벳의 개수와 현재까지의 startIdx부터 endIdx까지의 알파벳 개수 비교
	public static boolean checkWord(int startIdx, int endIdx) {
		for (int i = startIdx; i <= endIdx; i++) {
			if (alpCount[sList[i]] != slideCount[sList[i]])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;
		int startIdx = 0;
		int endIdx = 0;
		
		int wLength = Integer.parseInt(st.nextToken()); // 찾고자 하는 단어 W의 길이
		int sLength = Integer.parseInt(st.nextToken()); // 문자열 S의 길이
		String W = br.readLine();
		String S = br.readLine();
		sList = S.toCharArray();	//	문자열 S 배열

		for (int i = 0; i < wLength; i++) {
			alpCount[W.charAt(i)]++;
		}

		while (endIdx < sLength) {

			// W에 없는 문자
			if (alpCount[sList[endIdx]] == 0) {
				for (int i = startIdx; i <= endIdx; i++) {
					if (slideCount[sList[i]] == 0)
						slideCount[sList[i]] = 0;
					else
						slideCount[sList[i]]--;
				}
				startIdx = ++endIdx;
			}
			// W에 있는 문자
			else {
				
				slideCount[sList[endIdx]]++;

				if (endIdx - startIdx + 1 == wLength) {

					if (checkWord(startIdx, endIdx)) {
						answer++;
					}

					slideCount[sList[startIdx]]--;
					startIdx++;
				}
				endIdx++;
			}
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
