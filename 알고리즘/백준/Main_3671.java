import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//  BOJ_3671  92360kb  472ms
public class Main_3671 {
  
    static String input;
    static int len;
    static boolean[] isPrime;
    static boolean[] isPicked;
    static Set<Integer> primeCount;

    public static void dfs(String num){
        for (int i = 0; i < len; i++) {
            if(!isPicked[i]){
                String n = num + input.charAt(i);
                if(isPrime[Integer.parseInt(n)]) {
                    primeCount.add(Integer.parseInt(n));
                }
                isPicked[i] = true;
                dfs(n);
                isPicked[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        primeCount = new HashSet<>();
        int c = Integer.parseInt(br.readLine());    //  테스트 케이스 최대 200
        isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if(isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < c; i++) {
            input = br.readLine();   //  최대 길이 7
            len = input.length();
            isPicked = new boolean[len];
            primeCount.clear();
            dfs("");
            answer.append(primeCount.size()).append("\n");

        }

        br.close();
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
