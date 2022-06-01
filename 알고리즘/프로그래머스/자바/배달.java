import java.util.PriorityQueue;
import java.util.ArrayList;
class Solution {
    public int solution(int N, int[][] road, int K) {
        boolean[] visited = new boolean[N+1];
        int[] time = new int[N+1];
        ArrayList<int[]>[] route = new ArrayList[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int answer = N;
        
        for(int town = 1; town <= N; town++){
            route[town] = new ArrayList<>();
            time[town] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < road.length; i++){
            route[road[i][0]].add(new int[]{road[i][1],road[i][2]});
            route[road[i][1]].add(new int[]{road[i][0],road[i][2]});
        }
        
        visited[1] = true;
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(!visited[now[0]]){
                time[now[0]] = now[1];
                if(time[now[0]] > K)
                    answer--;
            }
            visited[now[0]] = true;
            for(int i = 0; i < route[now[0]].size(); i++){
                int[] next = route[now[0]].get(i);
                if(time[next[0]] > next[1] + now[1]){
                    time[next[0]] = next[1] + now[1];
                    pq.add(new int[]{next[0], next[1] + now[1]});
                }
            }
        }
        
        return answer;
    }
}
