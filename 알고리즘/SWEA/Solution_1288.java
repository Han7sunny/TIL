import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution_1288 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());

			int num = 0;
			int count = 0;

//			Map<Character, Integer> check = new HashMap<>();
//			while(count < 10) {
//				num += N;
//				char[] number = Integer.toString(num).toCharArray();
//
//				for (int i = 0; i < number.length; i++) {
//					if(!check.containsKey(number[i])) {
//						count++;
//						check.put(number[i], 1);
//					}
//				}
//			}
			
			// Bit Masking
			int total = (1 << 10) - 1;
			int visited = 0;
			while(count < 10) {
				num += N;
				char[] number = Integer.toString(num).toCharArray();
				for (int i = 0; i < number.length; i++) {
					visited = visited | (1 << (number[i] - '0')); // 있으면 1 없으면 0
				}
				if(total == visited) break;
			}

			answer.append("#").append(test_case).append(" ").append(num).append("\n");
		}
		
		bw.write(answer.toString());
		br.close();
		bw.flush();
		bw.close();
		
	}
}
