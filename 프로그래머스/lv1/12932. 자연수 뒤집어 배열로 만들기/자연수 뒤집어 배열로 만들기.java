class Solution {
    public int[] solution(long n) {
        
        String num_str = Long.toString(n);
        int [] answer = new int[num_str.length()];
        int j = 0;
        for(int i = num_str.length()-1;i>=0;i--){
            answer[j]=num_str.charAt(i)-'0';
            j++;
        }
        return answer;
    }
}