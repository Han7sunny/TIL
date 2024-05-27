import java.io.*;

//  BOJ_9655    11596kb  76ms
public class Main_9655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //  최대 1000

        br.close();
        bw.write((N % 2 == 1) ? "SK" : "CY");
        bw.flush();
        bw.close();
    }
}
