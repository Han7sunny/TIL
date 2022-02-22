import java.util.ArrayList;
class Solution {
    String[] alp = {"A","E","I","O","U"};
    ArrayList<String> words = new ArrayList<>();
    public void pick(String pick_str){
        if(pick_str.length() > 0){
            words.add(pick_str);
            if (pick_str.length() == alp.length)
                return;
        }
        for(int i = 0; i < alp.length; i++){
            pick_str += alp[i];
            pick(pick_str);
            pick_str = pick_str.substring(0,pick_str.length()-1);
        }
    }
    public int solution(String word) {
        pick("");
        return words.indexOf(word)+1;
    }
}
