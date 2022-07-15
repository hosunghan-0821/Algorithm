import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        ArrayList<Integer> array = new ArrayList<>();
        long answer = 0;
        String num_str = Long.toString(n);
        for(int i = 0 ; i<num_str.length();i++){
            array.add(num_str.charAt(i)-'0');
        }
        Collections.sort(array);
        for(int i = 0 ; i<array.size();i++){
            answer += array.get(i)*Math.pow(10,i);
        }
        return answer;
    }
}