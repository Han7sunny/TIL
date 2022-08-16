import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// JGL 1828 냉장고 28,812kb 127ms
// 최고 보관 온도를 기준으로 정렬하여 현 최저 보관 온도가 이전의 최고 보관 온도보다 작거나 같지 않으면 냉장고 대수를 증가시켰습니다.
public class Main_1828_냉장고 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] temp = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken()); // 최저 보관 온도 
			temp[i][1] = Integer.parseInt(st.nextToken()); // 최고 보관 온도
		}
		
		Arrays.sort(temp, new Comparator<int[]>() {

			@Override
			public int compare(int[] tmp1, int[] tmp2) {
				if(tmp1[1] == tmp2[1])
					return tmp1[0] - tmp2[0]; 
				return tmp1[1] - tmp2[1];
			}
		
		});

		int min = temp[0][0];
		int max = temp[0][1];
		int refrigerator = 1;
		for (int i = 1; i < N; i++) {
			if(temp[i][0] <= max) {
				min = Math.max(min, temp[i][0]);
			}else {
				refrigerator++;
				min = temp[i][0];
				max = temp[i][1];
			}
		}
		bw.write(Integer.toString(refrigerator));
		br.close();
		bw.flush();
		bw.close();
	}

}
