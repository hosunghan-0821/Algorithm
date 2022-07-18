import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer =new int[2];
        int GCD=gcd(m,n);
        int LCM = m*n/GCD; 
        answer[0]=GCD;
        answer[1]=LCM;

        return answer;
    }
    // 최대공약수 구하는 함수     
    public int gcd(int big_n , int sm_n ){
        if(big_n%sm_n ==0){
            return sm_n;
        }
        else{
            return gcd(sm_n,big_n%sm_n);
        }
    }
    // 최소공약수 구하는 함수
    
}