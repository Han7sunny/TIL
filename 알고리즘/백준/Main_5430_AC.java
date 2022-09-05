import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

//BOJ 5430 97,712kb 968ms
public class Main_5430_AC {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			Deque<Integer> dq = new ArrayDeque<>();
			boolean rCheck = false;
			boolean isEmpty = false;
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] arr = input.substring(1, input.length() - 1).split("[,]");
			for (int i = 0; i < n; i++) {
				dq.addLast(Integer.parseInt(arr[i]));
			}

			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					rCheck = rCheck ? false : true;
				} else { // D

					if (dq.isEmpty()) {
						isEmpty = true;
						break;
					}

					if (rCheck)
						dq.pollLast();
					else
						dq.pollFirst();

				}
			}

			if (isEmpty)
				result.append("error\n");
			else {
				result.append("[");
				while (!dq.isEmpty()) {
					if (rCheck)
						result.append(dq.pollLast());
					else
						result.append(dq.pollFirst());

					if (!dq.isEmpty())
						result.append(",");
				}

				result.append("]\n");
			}
		}
		bw.write(result.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
