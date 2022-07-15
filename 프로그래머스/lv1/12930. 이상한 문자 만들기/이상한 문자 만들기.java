import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean upper_check =true;
        for (int i = 0 ; i < s.length();i++){
            // 한 문자 추출 한 다음에,
            // String 으로 바꾸고 붙이기              
            char ch = s.charAt(i);
            String word = Character.toString(ch);
            if(word.equals(" ")){
                answer+=word;
                upper_check=true;
                continue;
            }
            if(upper_check){
                 word=word.toUpperCase();
                 answer+=word;
                 upper_check=!upper_check;
            }
            else{
                word=word.toLowerCase();
                answer+=word;
                 upper_check=!upper_check;
            }
        }
        return answer;
    }
}