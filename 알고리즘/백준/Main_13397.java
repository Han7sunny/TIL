import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	BOJ_13397	13400kb	120ms
public class Main_13397 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 배열 개수
		int M = Integer.parseInt(st.nextToken()); // 구간 개수

		int[] arr = new int[N];

		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		while (left < right) {

			int mid = (left + right) / 2;
			
			int cnt = 1;
			int min = 10001;
			int max = 0;

			for (int i = 0; i < N; i++) {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);

				if (max - min > mid) {
					cnt++;
					min = 10001;
					max = 0;
					i--;	//	예제 2와 같이 같은 수로 구성된 구간 확인하기 위함
				}
			}

			if (cnt > M)
				left = mid + 1;
			else
				right = mid;

		}

		br.close();
		bw.write(Integer.toString(right));
		bw.flush();
		bw.close();

	}

}
