import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] op = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void cal(int[] pick, int k) {
		if(k == 0) {
			int sum = pick[0];
			for(int i = 1; i < pick.length; i+=2) {
				if(pick[i] == 0)
					sum += pick[i+1];
				else if(pick[i] == 1)
					sum -= pick[i+1];
				else if(pick[i] == 2)
					sum *= pick[i+1];
				else
					sum /= pick[i+1];
			}
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		int lastIndex = pick.length - 2*k;
		for(int i = 0; i < op.length; i++) {
			if(op[i] > 0) {
				pick[lastIndex] = i;
				op[i]--;
				cal(pick,k-1);
				op[i]++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[2*N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2*N; i+=2) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		cal(num,N-1);
		br.close();
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
}

// 다른 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] number;
	static int[] op = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void cal(int sum, int idx) {
		if(idx == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i < op.length; i++) {
			if(op[i] > 0) {
				op[i]--;
				switch(i) {
					case 0:
						cal(sum + number[idx], idx+1);
						break;
					case 1:
						cal(sum - number[idx], idx+1);
						break;
					case 2:
						cal(sum * number[idx], idx+1);
						break;
					case 3:
						cal(sum / number[idx], idx+1);
						break;
				}
				op[i]++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		cal(number[0],1); // 첫번째 값 넣어주기
		br.close();
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
}
