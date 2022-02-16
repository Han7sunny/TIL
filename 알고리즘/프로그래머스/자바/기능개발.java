import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
          if ((100 - progresses[i]) % speeds[i] == 0)
            queue.add((100 - progresses[i]) / speeds[i]);
          else
            queue.add((100 - progresses[i]) / speeds[i] + 1);
        }
        while(!queue.isEmpty()) {
          int pre = queue.poll();
          int cnt = 1;
          while(queue.size() >= 1 && pre >= queue.peek()) {
            queue.poll();
            cnt++;
          }
          answer.add(cnt);
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
          result[i]=answer.get(i);
        return result;
        }
}
