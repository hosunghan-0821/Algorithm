class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total_num = brown+yellow;
        int width=0, length=0;
        for(int i = 1 ; i<brown/2;i++){
            width= brown/2-i;
            length = i ;
            
            if( (width+1)*(length+1) == total_num){
                break;
            }
            
        }
        answer[0]=width+1;
        answer[1]=length+1;
        return answer;
    }
}