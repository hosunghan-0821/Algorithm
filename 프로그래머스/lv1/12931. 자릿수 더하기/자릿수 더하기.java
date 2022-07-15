import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String words = Integer.toString(n);
        for(int i = 0 ; i <words.length();i++){
            int num = words.charAt(i)-'0';
            answer+= num;
        }
        return answer;
    }
}