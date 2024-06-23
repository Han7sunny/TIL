import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        //  가장 먼저 탈락하는 사람의 번호, 자신의 몇 번째 차례에 탈락하는지
        //  탈락자가 발생하지 않는다면 [0, 0]
        
        Set<String> wordSet = new HashSet<>();        
        int[] answer = {0, 0};
        
        wordSet.add(words[0]);
        for(int i = 1; i < words.length; i++){
            
            int num = (i % n) + 1;
            int order = (i / n) + 1;
            
            if(words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0) || wordSet.contains(words[i])){
                answer[0] = num;
                answer[1] = order;
                break;
            }
            
            wordSet.add(words[i]);
        }
        
        return answer;
    }
}
