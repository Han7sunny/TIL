import java.io.*;
import java.util.*;

public class Softeer_6294 {
	
	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 구간 수

        double[] score = new double[N + 1];
        double[] sum = new double[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
          score[i] = Double.parseDouble(st.nextToken());
          sum[i] = sum[i-1] + score[i];
        }

        for(int i = 0; i < K; i++){
          st = new StringTokenizer(br.readLine());
          int A = Integer.parseInt(st.nextToken()); 
          int B = Integer.parseInt(st.nextToken());
          double avg = (sum[B] - sum[A - 1]) / (B - A + 1);
          
          // 소수 셋째자리에서 반올림
          answer.append(String.format("%.2f", avg)).append("\n");
        }

        br.close();
		bw.write(answer.toString());
		bw.flush();
		bw.close();

    }

}
