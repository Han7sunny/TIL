package 프로그래머스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
					sum = sum - pick[i+1];
				else if(pick[i] == 2)
					sum = sum * pick[i+1];
				else
					sum = sum / pick[i+1];
			}
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		int lastIndex = pick.length - 2*k;
		for(int i = 0; i < op.length; i++) {
			if(op[i] != 0) {
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
		for(int i = 0; i <= N; i+=2) {
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
