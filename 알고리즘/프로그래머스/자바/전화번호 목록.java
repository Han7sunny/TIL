import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String pb : phone_book)
            hm.put(pb, pb.length());
        
        for(String pb : phone_book){
            for(Entry<String,Integer> e : hm.entrySet()){
                if(e.getKey() != pb && e.getKey().startsWith(pb))
                    return false;
            }
        }
        return true;
    }
}
