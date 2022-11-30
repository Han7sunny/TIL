import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_2992_크면서작은수 {

	static String X;
	static String[] num;
	static String answer = "0";

	public static void numberPerm(int idx, String number, boolean[] visited) {
		if (idx == num.length) {
			if (Integer.parseInt(number) > Integer.parseInt(X)) {
				answer = number;
			}
			return;
		}

		if (answer.equals("0")) {
			for (int i = 0; i < num.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					numberPerm(idx + 1, number + num[i], visited);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		X = br.readLine();
		int prev = 9;
		boolean check = false; // X의 각 자리 수가 내림차순으로 이루어져있다면 그보다 큰 수는 존재하지 않음
		num = new String[X.length()];
		for (int i = 0; i < num.length; i++) {
			num[i] = Character.toString(X.charAt(i));
			if (prev < Integer.parseInt(num[i]))
				check = true;
			else
				prev = Integer.parseInt(num[i]);
		}

		if (check) {
			Arrays.sort(num);
			numberPerm(0, "", new boolean[num.length]);
		}
		bw.write(answer);
		br.close();
		bw.flush();
		bw.close();
	}

}
