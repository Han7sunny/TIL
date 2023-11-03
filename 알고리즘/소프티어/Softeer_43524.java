import java.io.*;
import java.util.*;

//	소프티어_금고털이
public class Softeer_43524 {

	public static class Metal implements Comparable<Metal> {

		private int weight;
		private int price;

		public Metal(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Metal other) {
			return other.price - this.price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken()); // 배낭 무게
		int N = Integer.parseInt(st.nextToken()); // 귀금속 종류

		int answer = 0;
		Metal[] list = new Metal[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 금속 무게
			int p = Integer.parseInt(st.nextToken()); // 무게당 가격

			list[i] = new Metal(m, p);

		}

		Arrays.sort(list); // 무게당 가격으로 정렬

		for (int i = 0; i < N; i++) {
			if (W > list[i].weight) {
				answer += list[i].weight * list[i].price;
				W -= list[i].weight;
			} else {
				answer += W * list[i].price;
				break;
			}
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}
}
