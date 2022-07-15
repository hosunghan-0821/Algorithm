class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left ; i<=right ; i++){
            if(check_diviser_num(i)){
                answer+=i;
            }
            else{
                answer-=i;
            }
        }
        
        return answer;
    }
    
    public boolean check_diviser_num(int num){
        int sum=0;
    //약수 개수 세는 for 문         
        for (int i = 1 ; i <=Math.sqrt(num);i++){
            int quotient,remainder;
            quotient = num / i;
            remainder = num % i ;
            if(remainder == 0 ){
                if(quotient == i ){
                    sum+=1;
                }
                else {
                    sum+=2;
                }
            }
        }
        if(sum %2 ==0){
            return true;
        }
        else{
            return false;
        }
        
    }
}