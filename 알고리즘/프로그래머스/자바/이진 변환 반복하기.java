class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int length = s.length();
        while(!s.equals("1")) {
          length = s.length();
          if(s.contains("0")) {
            s = s.replace("0", "");
            answer[1] += length - s.length();
          }
          s = Integer.toBinaryString(s.length());
          answer[0]++;
        }
        return answer;
    }
}
