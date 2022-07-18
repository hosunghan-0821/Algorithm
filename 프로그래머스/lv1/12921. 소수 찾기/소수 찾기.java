import java.util.*;
class Solution {
    boolean[] checkPrime;
    public int solution(int n) {
        int answer = 0;
        checkPrime = new boolean[n+1];
        Arrays.fill(checkPrime,true);
        for(int i = 2 ; i<=n;i++){
            if(isPrime(i))
                answer++;
        }
        return answer;
        
    }
    public boolean isPrime(int num){
        boolean check =true;
        //checkPrime 전역변수에 값이 false 인지 확인하고 
        //false 면 검사할 필요없이 소수가 아니다
        //true 면 검사 진행.
        if(!checkPrime[num]){
            return false;
        }
        for(int j = num + num ; j<checkPrime.length; j+=num){
            checkPrime[j]=false;
        }
        
        return check;
    }
}