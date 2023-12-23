import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//	BOJ_17779	28564kb	324ms
public class Main_17779 {

	static int answer, N, totalPopulation;
	static int[][] population;

	public static void divideDistricts(int x, int y, int d1, int d2) {

		boolean[][] line = new boolean[N][N]; // 경계선
		int[] districtSum = new int[5]; // 선거구 인구 수 합

		//	경계선
		for (int i = 0; i <= d1; i++) {
			line[x + i][y - i] = true;
			line[x + d2 + i][y + d2 - i] = true;
		}
		
		for (int i = 0; i <= d2; i++) {
			line[x + i][y + i] = true;
			line[x + d1 + i][y - d1 + i] = true;
		}

		// 1번 선거구 ->
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if(line[i][j]) break;	//	경계선 만나면 다음 줄로 건너뛰기
				districtSum[0] += population[i][j];
			}
		}
		
		// 2번 선거구 <-
		for (int i = 0; i <= x + d2; i++) {
			for (int j = N - 1; j > y; j--) {
				if(line[i][j])	break;	
				districtSum[1] += population[i][j];
			}
		}
		
		// 3번 선거구 ->
		for (int i = x + d1; i < N; i++) {
			for (int j = 0; j < y - d1 + d2; j++) {
				if(line[i][j])	break;	
				districtSum[2] += population[i][j];
			}
		}
		
		// 4번 선거구 <-
		for (int i = x + d2 + 1; i <N; i++) {
			for (int j = N - 1; j >= y - d1 + d2; j--) {
				if(line[i][j])	break;	
				districtSum[3] += population[i][j];
			}
		}
		
		// 5번 선거구
		districtSum[4] = totalPopulation;
		for (int i = 0; i < 4; i++) {
			districtSum[4] -= districtSum[i];
		}
		
		Arrays.sort(districtSum);
		
		answer = Math.min(answer, districtSum[4] - districtSum[0]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		answer = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine()); // 최대 20

		population = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
				totalPopulation += population[i][j];
			}
		}

		// x, y, d1, d2 경우의 수 구하기
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						
						if (x + d1 + d2 >= N)
							continue;
						if (y - d1 < 0 || y + d2 >= N)
							continue;

						divideDistricts(x, y, d1, d2);
					}
				}
			}
		}

		br.close();
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

}
