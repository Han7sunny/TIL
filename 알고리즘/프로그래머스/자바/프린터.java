import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;

// 배열 구현
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
    	PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i],i}); // 중요도, 순서
            priority.add(priorities[i]);
        }
        int answer = 0;
        while(!queue.isEmpty()) {
        	int[] now = queue.poll();
        	if (!priority.isEmpty()) { // 우선순위
        		if (now[0] < priority.peek())
        			queue.add(now);
        		else {
        			priority.poll();
        			answer++;

        			if (now[1] == location)
        				return answer;
        		}
        	}
        }
        return answer;
    }
}

// class 구현
class Solution {
    class Document{
		private int priority;
		private int position;
		
		public Document(int priority, int position) {
			this.priority = priority;
			this.position = position;
		}
	}
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
    	PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i],i)); // 중요도, 순서
            priority.add(priorities[i]);
        }
        int answer = 0;
        while(!queue.isEmpty()) {
        	Document now = queue.poll();
        	if (!priority.isEmpty()) { // 우선순위
        		if (now.priority < priority.peek())
        			queue.add(now);
        		else {
        			priority.poll();
        			answer++;

        			if (now.position == location)
        				return answer;
        		}
        	}
        }
        return answer;
    }
}
