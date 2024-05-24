import java.io.*;
import java.util.*;

public class Main_12886 {

    public static class Stone {
        private int A;
        private int B;
        private int C;

        public Stone(int A, int B, int C){
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = 0;

        if((A + B + C)  % 3 == 0){
            //  세 개의 그룹 내 돌의 개수 동일하게 만들기
            //  1.  크기가 같지 않은 그룹 2개 고른다.
            //  2.  작은 쪽 X, 큰 쪽 Y에서 X + X / Y - X로 만든다.

            boolean[][] checked = new boolean[1501][1501];
            Queue<Stone> q = new ArrayDeque<>();

            checked[A][B] = true;
            q.add(new Stone(A, B, C));

            while(!q.isEmpty()){

                Stone now = q.poll();

                if(now.A == now.B && now.B == now.C){
                    answer = 1;
                    break;
                }

                if(now.A != now.B){

                    int na = (now.A > now.B) ? now.A - now.B : 2 * now.A;
                    int nb = (now.A > now.B) ? 2 * now.B : now.B - now.A;

                    if(!checked[na][nb]){
                        checked[na][nb] = true;
                        q.add(new Stone(na, nb, now.C));
                    }

                }

                if(now.A != now.C){

                    int na = (now.A > now.C) ? now.A - now.C : 2 * now.A;
                    int nc = (now.A > now.C) ? 2 * now.C : now.C - now.A;

                    if(!checked[na][nc]){
                        checked[na][nc] = true;
                        q.add(new Stone(na, now.B, nc));
                    }

                }

                if(now.B != now.C){

                    int nb = (now.B > now.C) ? now.B - now.C : 2 * now.B;
                    int nc = (now.B > now.C) ? 2 * now.C : now.C - now.B;

                    if(!checked[nb][nc]){
                        checked[nb][nc] = true;
                        q.add(new Stone(now.A, nb, nc));
                    }

                }

            }

        }

        br.close();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
