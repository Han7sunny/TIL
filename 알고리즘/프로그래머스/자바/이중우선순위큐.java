import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> desc = new PriorityQueue<>((a,b)->b-a); // 내림차순
        int[] answer = {0, 0};
        for(int i = 0; i < operations.length; i++){
            if(operations[i].contains("I")){
                asc.add(Integer.parseInt(operations[i].split(" ")[1]));
                desc.add(Integer.parseInt(operations[i].split(" ")[1]));
            }else if(operations[i].contains("D") && !asc.isEmpty()){
                if(operations[i].contains("-") ){  
                    int min = asc.peek();
                    asc.remove(min);
                    desc.remove(min);
                }
                else{
                    int max = desc.peek();
                    asc.remove(max);
                    desc.remove(max);
                }
            }
        }
        
        if(!asc.isEmpty() && !desc.isEmpty()){ // [최댓값, 최솟값]
            answer[0] = desc.peek();
            answer[1] = asc.peek();
        }
        return answer;
    }
}
