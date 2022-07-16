import java.util.*;
class Solution {
    public int solution(String s) {
        String answer_str = "" ;
        int answer = 0;
        for(int i = 0 ; i < s.length();i++){
            // 숫자 0 <= x <9 일 경우             
            if(s.charAt(i)-'0'>=0 &&s.charAt(i)-'0'<=9){
                answer_str+=s.charAt(i);
            }
            else{
                String check_str = s.substring(i,i+2);
                ArrayList<String> arr = new ArrayList<>();
                arr = check_char_num(check_str);
                i += Integer.parseInt(arr.get(1))-1;
                answer_str+=arr.get(0);
                // System.out.println(arr.get(0));
                // System.out.println(arr.get(1));
            }
        }
        answer = Integer.parseInt(answer_str);
        return answer;
    }
    public ArrayList<String> check_char_num(String check_str){
        
        ArrayList<String> arr  = new ArrayList<>();
        switch (check_str){
            case "ze":
                //  숫자 & 문자의 개수                
                arr.add("0");
                arr.add("4");
                break;
            case "on":
                arr.add("1");
                arr.add("3");
                break;
            case "tw":
                arr.add("2");
                arr.add("3");
                break;
            case "th":
                arr.add("3");
                arr.add("5");
                break;
            case "fo":
                arr.add("4");
                arr.add("4");
                break;
            case "fi":
                arr.add("5");
                arr.add("4");
                break;
            case "si":
                arr.add("6");
                arr.add("3");
                break;
            case "se":
                arr.add("7");
                arr.add("5");
                break;
            case "ei":
                arr.add("8");
                arr.add("5");
                break;
            case "ni":
                arr.add("9");
                arr.add("4");
                break;
                
        }
        return arr;
    }
}