import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//	BOJ_2212 15800kb 212ms
public class Main_2212 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int answer = 0;

		int N = Integer.parseInt(br.readLine()); // 센서 개수
		int K = Integer.parseInt(br.readLine()); // 집중국 개수

		// 중복 제거
		Set<Integer> locationList = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			locationList.add(Integer.parseInt(st.nextToken()));
		}

		int size = locationList.size();

		// 센서 위치 정렬
		List<Integer> sortedLocation = new ArrayList<>(locationList);
		Collections.sort(sortedLocation);

		if (size == 1)
			answer = 0;
		else if (size == 2)
			answer = sortedLocation.get(1) - sortedLocation.get(0);
		else {
			// 센서 간 거리 차 구하기
			int[] dist = new int[size - 1];
			for (int i = size - 1; i > 0; i--) {
				dist[i - 1] = sortedLocation.get(i) - sortedLocation.get(i - 1);
			}
			Arrays.sort(dist);

			// 고속도로 총 거리 - 센서 간 최대 거리
			answer = sortedLocation.get(size - 1) - sortedLocation.get(0);
			int idx = size - 2;
			for (int i = 0; i < K - 1; i++) {
				answer -= dist[idx--];
			}
		}
		
		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
