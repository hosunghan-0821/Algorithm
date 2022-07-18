class Solution {
    public int solution(int n) {
        int answer = 0;
        int remainder=0,quotient=0;

        for(int i = 1 ; i <=Math.sqrt(n);i++){
            quotient = n/i ;
            remainder = n%i ;
            if(remainder == 0 ){
                if(i == quotient){
                    answer+=quotient;
                }
                else{
                    answer+=quotient;
                    answer+=i;
                }
                
            }
        }
        return answer;
    }
}