import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//	BOJ_13904 13096kb 136ms
public class Main_13904 {
	
	public static class Homework implements Comparable<Homework> {

		private int d;
		private int w;

		public Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}

		public int compareTo(Homework other) {
			return other.w - this.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		List<Homework> hwList = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			hwList.add(new Homework(d, w));
		}

		Collections.sort(hwList); // w 기준 내림차순
		
		for (int day = N; day > 0; day--) {
			Homework max = new Homework(0, 0);
			for (Homework hw : hwList) {
				if (hw.d >= day && max.w < hw.w) {
					max = hw;
				}
			}
			answer += max.w;
			hwList.remove(max);
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
