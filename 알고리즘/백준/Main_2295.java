import java.io.*;
import java.util.*;

//  BOJ_2295    45020kb 300ms
public class Main_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d = -1;
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum.add(U[i] + U[j]);
            }
        }

        Arrays.sort(U);
        out:for (int i = N - 1; i >= 0 ; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if(sum.contains(U[i] - U[j])){
                    d = U[i];
                    break out;
                }
            }
        }

        br.close();
        bw.write(Integer.toString(d));
        bw.flush();
        bw.close();
    }
}
