class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int days[] ={31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int total_days =0;
        for(int i=0;i<a-1;i++){
            total_days+=days[i];
        }
        total_days+=b;
        int answer_num=total_days%7;
        return day[answer_num];
    }
}