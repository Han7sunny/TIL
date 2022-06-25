import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> work = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i < works.length; i++)
            work.add(works[i]);
        
        for(int i = 0; i < n; i++){
            if(!work.isEmpty()){
                int now = work.poll();
                if(now - 1 >= 0)
                    work.add(now - 1);
            }
        }
        
        long answer = 0;
        while(!work.isEmpty()){
            answer += Math.pow(work.poll(), 2);
        }
        return answer;
    }
}
