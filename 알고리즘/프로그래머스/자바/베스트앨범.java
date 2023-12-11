import java.util.*;
class Solution {

    public class Info implements Comparable<Info>{
        private int num;
        private int play;

        public Info(int num, int play){
            this.num = num;
            this.play = play;
        }

        public int compareTo(Info other){
            if(other.play == this.play)
                return this.num - other.num;
            return other.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        int len = genres.length;
        Map<String, PriorityQueue<Info>> list = new HashMap<>();
        Map<String, Integer> playCount = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();
    
        for(int i = 0; i < len; i++){
            if(!list.containsKey(genres[i]))
                list.put(genres[i], new PriorityQueue<>());

            list.get(genres[i]).add(new Info(i, plays[i]));
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
        }


        List<String> keySet = new ArrayList<>(playCount.keySet());

        keySet.sort(new Comparator<String> () {
            public int compare(String g1, String g2){
                return playCount.get(g2).compareTo(playCount.get(g1));
            }
        });

        //  재생 횟수 기준 정렬
        for(String g : keySet){
            if(list.get(g).size() == 1)
                ansList.add(list.get(g).poll().num);
            else{
                for(int i = 0; i < 2; i++){
                    ansList.add(list.get(g).poll().num);
                }
            }
        }

        answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
