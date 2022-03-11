class Solution {
    public int solution(int n) {
        for(int i = 1; ; i++){
            // Integer.bitCount(int) : Returns the number of one-bits in the two's complement binaryrepresentation of the specified int value.
            if(Integer.bitCount(n) == Integer.bitCount(n+i))
                return n+i;
        }
    }
}
