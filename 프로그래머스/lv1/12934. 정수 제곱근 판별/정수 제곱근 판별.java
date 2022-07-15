class Solution {
    public long solution(long n) {
        long answer = 0;
//        원시 primitive 쓰면 안된다.
//        객체형태의  Double class 써야지 intValue() 가 먹는다. 
        double sqrt = Math.sqrt(n);
        
        if(sqrt ==  (int)sqrt ){
            answer =  (long)Math.pow(sqrt + 1, 2);
        }
        else{
            answer = -1;
        }
        return answer;

 
    }
}