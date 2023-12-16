import java.io.*;
import java.util.*;

//  비밀 메뉴 2
public class Softeer_6259 {
	public static void main(String[] args) throws IOException {
		
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int N = Integer.parseInt(st.nextToken());	//	첫번째 조작법 길이
    		int M = Integer.parseInt(st.nextToken());	//	두번째 조작법 길이
    		int K = Integer.parseInt(st.nextToken());	//	각 정수의 최대값
    
        int answer = 0;
          
    		int[][] dp = new int[N + 1][M + 1];
    		int[] button1 = new int[N + 1];
    		int[] button2 = new int[M + 1];
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 1; i <= N; i++) {
    			button1[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 1; i <= M; i++) {
    			button2[i] = Integer.parseInt(st.nextToken());
    		}
    
    		for (int i = 1; i <= N; i++) {
    			for (int j = 1; j <= M; j++) {
    				if(button1[i] == button2[j]){
    					dp[i][j] = dp[i-1][j-1] + 1;
                        answer = Math.max(answer, dp[i][j]);
                    }
    				else
    					dp[i][j] = 0; // 연속되어야 함
    			}
    		}
    		
    		br.close();
    		bw.write(Integer.toString(answer));
    		bw.flush();
    		bw.close();
    }

}
