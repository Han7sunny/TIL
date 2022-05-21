import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] edge) {
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, List<Integer>> edges = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++)
            edges.put(i, new ArrayList<>());
        
        for(int i = 0; i < edge.length; i++){
            edges.get(edge[i][0]).add(edge[i][1]);
            edges.get(edge[i][1]).add(edge[i][0]);
        }
        
        visited[1] = true;
        q.add(new int[] {1,0}); // 1번 노드, 거리 0  
	      while(!q.isEmpty()) {
	       	int[] now = q.poll();
	    	  max = max < now[1] ? now[1] : max;
	       	count.put(now[1], count.getOrDefault(now[1], 0) + 1);
 	        for(int i = 0; i < edges.get(now[0]).size(); i++) {
        		if(!visited[edges.get(now[0]).get(i)]) {
        			visited[edges.get(now[0]).get(i)] = true;
        			q.add(new int[] {edges.get(now[0]).get(i), now[1] + 1});
                }
	        }    	
	      }
        return count.get(max);
    }
}
