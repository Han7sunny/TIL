class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
          skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]", ""); 
          // Replaces each substring of this string that matches the given regular expression(정규표현식) with thegiven replacement.  
          if(skill.startsWith(skill_trees[i]))
            answer++;
        }
        return answer;
    }
}
