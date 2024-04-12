import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberString =new String[numbers.length];
        
        for (int i = 0 ; i < numberString.length; i++) {
            numberString[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numberString,(o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (numberString[0].equals("0")) {
            return "0";
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0 ; i < numberString.length; i++) {
           sb.append(numberString[i]);
        }
        
        
        return sb.toString();
    }
}