import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
class Solution {
    HashMap<String,Integer> strOne = new HashMap<>();
    HashMap<String,Integer> strTwo = new HashMap<>();

    // 교집합
    public int intersection(HashSet<String> set1, HashSet<String> set2) {
      int answer = 0;
      HashSet<String> copySet = new HashSet<String>();
      copySet.addAll(set1);
      copySet.retainAll(set2);

      for(String s : copySet) {
        if(strOne.containsKey(s) && strTwo.containsKey(s))
          answer += strOne.get(s) < strTwo.get(s) ? strOne.get(s) : strTwo.get(s);
        else if(strOne.containsKey(s))
          answer += strOne.get(s);
        else
          answer += strTwo.get(s);
      }
      return answer;
    }

    //합집합
    public int union(HashSet<String> set1, HashSet<String> set2) {
      int answer = 0;
      HashSet<String> copySet = new HashSet<String>();
      copySet.addAll(set1);
      copySet.addAll(set2);
      for(String s : copySet) {
        if(strOne.containsKey(s) && strTwo.containsKey(s))
          answer += strOne.get(s) > strTwo.get(s) ? strOne.get(s) : strTwo.get(s);
        else if(strOne.containsKey(s)) 
          answer += strOne.get(s);
        else 
          answer += strTwo.get(s);
      }
      return answer;
    }
  
    public int solution(String str1, String str2) {
        int inter = 0;
		int union = 0;
		
		str1=str1.toUpperCase();
		str2=str2.toUpperCase();
		
		for(int i = 0; i + 1 < str1.length(); i++) {
			String two = str1.substring(i,i+2);			
			if(two.matches("[A-Z][A-Z]")) {
				strOne.put(two, strOne.getOrDefault(two, 0)+1);
			}
		}	
		for(int i = 0; i + 1 < str2.length(); i++) {
			String two = str2.substring(i,i+2);
			if(two.matches("[A-Z][A-Z]")) {
				strTwo.put(two, strTwo.getOrDefault(two, 0)+1);
			}
		}
		
		HashSet<String> setOne = new HashSet<>();
		HashSet<String> setTwo = new HashSet<>();	
		
		for(Entry<String,Integer> e :strOne.entrySet()) {
			setOne.add(e.getKey());
		}
		
		for(Entry<String,Integer> e :strTwo.entrySet()) {
			setTwo.add(e.getKey());
		}

		inter = intersection(setOne,setTwo);
		union = union(setOne,setTwo);
		if(inter == 0 && union == 0)
			return 1*65536;
		return (int)((double)inter/union*65536);
    }
}
