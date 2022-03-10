import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] house;
	public static int share(int dist) {
		int preIdx = 0;
		int count = 1; // 첫번째 무조건 선택
		for(int i = 1; i < house.length; i++) {
			if(house[i] - house[preIdx] >= dist) {
				count++;
				preIdx = i;
			}
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		house = new int[n];
		for(int i = 0; i < n; i++)
			house[i] = Integer.parseInt(br.readLine());
		Arrays.sort(house);
		// 이분탐색의 기준점을 거리로 
		int answer = 0;
		int start = 1; // 최소 거리
		int end = house[n-1] - house[0]; // 최대 거리
		while(start <= end) { 
			int mid = (start + end) / 2;
			if(share(mid) < c) // 공유기 개수가 c보다 작으면 거리를 줄여야 함
				end = mid - 1;
			else { // 공유기 개수 최소 c 만족하는 것 중 최대 거리
				answer = mid;
				start = mid + 1; 
			}
		}
		br.close();
		bw.write(answer+ "\n");
		bw.flush();
		bw.close();
	}
}
