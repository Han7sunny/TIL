import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(String s) {
        HashMap<Integer,Integer> list = new HashMap<>();
		String[] sList = s.replaceAll("[{}]", "").split(",");
		for(String sNum : sList) {
			int n = Integer.parseInt(sNum);
			list.put(n, list.getOrDefault(n, 0) + 1);
		}
		int[] answer = new int[list.size()];
		ArrayList<Integer> mapList = new ArrayList<>(list.keySet());
		Collections.sort(mapList,(o1,o2) -> (list.get(o2).compareTo(list.get(o1))));
    return mapList.stream().mapToInt(i->i).toArray();
    }
}
