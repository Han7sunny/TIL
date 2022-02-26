import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public int[] solution(String msg) {
        HashMap<String,Integer> words = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 65; i <= 90; i++)
          words.put(String.valueOf((char)i), i-64);
        int maxLength = 1;
        int i = 0;
        int j;
        while(i < msg.length()) {
          j = i + maxLength;
          if(j > msg.length()) 
            j = msg.length();

          while(j - i >= 1) {
            if(words.containsKey(msg.substring(i,j))) { 
              answer.add(words.get(msg.substring(i,j)));
              if(j == msg.length())
                break;
              words.put(msg.substring(i,j+1), (words.size()+1)); // 넣을때는 바로 뒤에 하나 포함헤서
              maxLength = maxLength < msg.substring(i,j+1).length() ? msg.substring(i,j+1).length() : maxLength;
              break;
            }
            j--;
          }				
          i = j;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
