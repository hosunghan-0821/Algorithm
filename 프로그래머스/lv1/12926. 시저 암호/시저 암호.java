class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0 ; i<s.length();i++){
            int ch_num=change_str(s.charAt(i) , n );
            answer += (char)(ch_num);
        }
        return answer;
    }
    public int change_str(char ch,int n){
        //대문자일경우
        if(ch>=65 && ch<=91){
           if(ch+n >90){
              return ch+n-26; 
           }
            else{
                return ch+n;
            }
        }
        //공백일 경우
        else if(ch==32){
            return ch;
        }
        //소문자일 경우
        else{
            if(ch+n>122){
                return ch+n-26;
            }
            else{
                return ch+n;
            }
        }
        
    }
}