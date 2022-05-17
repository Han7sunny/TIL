import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int solution(int[] people, int limit) {
        
        // 1. Deque 사용
        int answer = 0;
    	Deque<Integer> boat = new LinkedList<>();
    	Arrays.sort(people);
    	for(int i = 0; i < people.length; i++)
    		boat.offer(people[i]);
    	
    	while(!boat.isEmpty()) {
        
        // 맨 앞과 맨 뒤를 뽑았는데 값 초과 -> 결국 모두 다 초과할 수 밖에 없으니까 뒤에 값 혼자 빼줌
        if(boat.peekFirst() + boat.pollLast() <= limit) 
    		  boat.pollFirst();
        
//         if(boat.peekFirst() + boat.peekLast() > limit) { 
//     			boat.pollLast();
//     		}
//     		else {
//     			boat.pollFirst();
//     			boat.pollLast();
//     		}

    		answer++;
    	}
    	return answer;
        
        
        // 2. 배열 사용
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
    	Arrays.sort(people);
    	
    	while(start <= end) {
            // 맨 앞과 맨 뒤를 뽑았는데 값 초과 -> 결국 모두 다 초과할 수 밖에 없으니까 뒤에 값 혼자 빼줌
            if(people[start] + people[end] <= limit) 
                start++;
            end--;
            answer++;
           
    	}
    	return answer;

    }
}


