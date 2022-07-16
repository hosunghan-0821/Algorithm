class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] tenary_num = make_tenary_num(n).split("");
        
        int j= 0;
        for(int i=tenary_num.length-1; i >=0;i--){
            answer +=  Integer.parseInt(tenary_num[i])*Math.pow(3,j);
            j++;
        }
        return answer;
    }
    public String make_tenary_num(int num){
        String tenary_num="";
        while(num!=0){
            tenary_num+=Integer.toString(num%3);
            num/=3;
        }
        return tenary_num;
    }
}