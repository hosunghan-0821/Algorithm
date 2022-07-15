class Solution {
    public int solution(int num) {
        long answer = 0;
        long long_num = (long) num;
        for(int i = 1 ; i<=500;i++){
            if(long_num==1){
                return 0;
            }
            if(long_num%2==0){
                long_num/=2;
            }
            else {
                long_num=long_num*3+1;
            }
            if(long_num==1){
                return i;
            }
        }
        
        return -1;
    }
}