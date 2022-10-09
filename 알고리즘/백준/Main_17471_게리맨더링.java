import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 17471 12764kb 88ms
public class Main_17471_게리맨더링 {
	static int N, minPopulation;
	static int[] population;
	static int[][] conArea; // 서로 연결된 섬

	public static void splitArea(boolean[] area1, int pickCnt, int k) { // 부분집합

	    if (k == N + 1) {

	        if (0 < pickCnt && pickCnt < N) { // 아무것도 안 뽑거나 모두 뽑은 경우 제외
	            int startIdx1 = -1;
	            int startIdx2 = -1;
	            boolean[] area2 = new boolean[N + 1];
	            for (int i = 1; i <= N; i++) { // otherArea(area1);
	                if (!area1[i]) {
	                    if (startIdx2 == -1)
	                        startIdx2 = i;
	                    area2[i] = true;
	                } else if (startIdx1 == -1) { // area1[i] = true
	                    startIdx1 = i;
	                }
	            }

	            boolean[] area = Arrays.copyOf(area1, N+1); // reference 방지
	            boolean checkArea1 = checkSameArea(area, pickCnt, startIdx1);
	            
	            boolean[] otherArea = Arrays.copyOf(area2, N+1);
	            boolean checkArea2 = checkSameArea(otherArea, N - pickCnt, startIdx2);

	            if (checkArea1 && checkArea2) {
	                int min = Math.abs(calPopulation(area1) - calPopulation(area2));
	                minPopulation = Math.min(minPopulation, min);
	            }
	        }
	        return;
	    }

	    area1[k] = true;
	    splitArea(area1, pickCnt + 1, k + 1);

	    if (k > 1) {
	        area1[k] = false;
	        splitArea(area1, pickCnt, k + 1);
	    }
	}

	// cnt : 뽑힌 지역 개수
	public static boolean checkSameArea(boolean[] area, int cnt, int start) { // 서로 연결되어 있는지 확인
	    if (cnt == 1)
	        return true;

	    Queue<Integer> q = new ArrayDeque<>();
	    q.offer(start);
	    area[start] = false;
	    int count = 1; // 연결된 지역 개수
	    while (!q.isEmpty()) {
	        int now = q.poll();
	        if(conArea[now] == null) continue;
	        for (int i = 0; i < conArea[now].length; i++) {
	            if (area[conArea[now][i]]) {
	                area[conArea[now][i]] = false;
	                q.offer(conArea[now][i]);
	                count++;
	            }
	        }
	    }
	    return (count == cnt ? true : false);
	}

	public static int calPopulation(boolean[] area) {
	    int sum = 0;
	    for (int i = 1; i <= N; i++) {
	        if (area[i])
	            sum += population[i];
	    }
	    return sum;
	}

	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;

	    minPopulation = Integer.MAX_VALUE;
	    N = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    population = new int[N + 1];
	    conArea = new int[N + 1][];

	    int unconnect = 0;
	    for (int i = 1; i <= N; i++) {
	        population[i] = Integer.parseInt(st.nextToken()); // 각 구역 인구 수
	    }

	    for (int i = 1; i <= N; i++) {
	        st = new StringTokenizer(br.readLine());
	        int cnt = Integer.parseInt(st.nextToken());
	        if(cnt == 0)
	            unconnect++;
	        else {
	            conArea[i] = new int[cnt];
	            for (int j = 0; j < cnt; j++) {
	                conArea[i][j] = Integer.parseInt(st.nextToken()); // 각 구역과 연결되어 있는 구역
	            }
	        }
	    }
	    
	    if(unconnect < N)
	        splitArea(new boolean[N + 1], 0, 1);
	    else if(N == 2)
	    	minPopulation = Math.abs(population[1] - population[2]);

	    bw.write(Integer.toString(minPopulation == Integer.MAX_VALUE ? -1 : minPopulation)); // 모든 섬 연결하는 것 불가능 : -1
	    br.close();
	    bw.flush();
	    bw.close();
	}
}
