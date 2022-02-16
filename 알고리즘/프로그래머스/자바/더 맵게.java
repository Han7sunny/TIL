import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scv = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
          scv.add(scoville[i]);

        int count = 0;
        while (scv.peek() < K) {
          int first = scv.poll();
          int second = scv.poll()*2;
          if (scv.size() <= 2 & first + second < K)
            return -1;
          scv.add(first+second);			
            count++;
        }
        return count;
    }
}
