import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
		int i = 0;
		for(int[] command : commands) {
			int[] sliced = Arrays.copyOfRange(array, command[0] - 1, command[1]); // Copies the specified range of the specified array into a new array.
			Arrays.sort(sliced);
			result[i++] = sliced[command[2] - 1];
		}
		return result;
    }
}
