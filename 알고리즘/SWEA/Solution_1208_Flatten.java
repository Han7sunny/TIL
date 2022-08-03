import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			int[] box = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++)
				box[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(box);
			
			while(dump > 0) {
				if(box[99] - box[0] <= 1)
					break;
				box[99]--;
				box[0]++;
				dump--;
				Arrays.sort(box);
			}

			bw.write("#" + test_case + " " + (box[99] - box[0]) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
