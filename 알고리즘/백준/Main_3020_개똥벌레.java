import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3020_개똥벌레 {

public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int min = Integer.MAX_VALUE;
    int count = 0;
    
    int N = Integer.parseInt(st.nextToken()); // 동굴 크기, 항상 짝수
    int H = Integer.parseInt(st.nextToken()); // 동굴 높이
    
    int[] bottom = new int[N/2];
    int bottomIdx = 0;
    int[] top = new int[N/2];
    int topIdx = 0;
    
    for (int i = 0; i < N; i++) {
        if(i % 2 == 0)
            bottom[bottomIdx++] = Integer.parseInt(br.readLine());
        else
            top[topIdx++] = Integer.parseInt(br.readLine());
        
    }
    
    Arrays.toString(bottom);
    Arrays.toString(top);
    
    int[] bottomSum = new int[bottom[bottomIdx-1]];
    int[] topSum = new int[top[topIdx-1]];
    
    
//        누적합 ...
//        for (int i = bottom[bottomIdx-1]; i >= 1; i--) {
//
//        }


//        파괴해야하는 장애물의 최솟값과 그러한 공간의 수

        bw.write(min + " " + count);
        br.close();
        bw.flush();
        bw.close();

    }

}