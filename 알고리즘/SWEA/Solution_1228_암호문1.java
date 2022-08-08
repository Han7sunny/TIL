import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

//	SWEA 1228 암호문1 18,504kb 121ms
//	ArrayList를 사용하여 풀었습니다.
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1; test_case <= 10; test_case++) {
			ArrayList<String> list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			int cmdCount = Integer.parseInt(br.readLine());
			String[] cmd = br.readLine().split("I");
			for (int i = 1; i <= cmdCount; i++) {
				String[] temp = cmd[i].trim().split(" ");

				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				
				for (int j = temp.length - 1; j >= 2 ; j--) {
					list.add(x, temp[j]);
				}
			
			}
			StringBuilder result = new StringBuilder();
			result.append("#").append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				result.append(list.get(i));
				if(i < 9)
					result.append(" ");
				else
					result.append("\n");
			}
			bw.write(result.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
