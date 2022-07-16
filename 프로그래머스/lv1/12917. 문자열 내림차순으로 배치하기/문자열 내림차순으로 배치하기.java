import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<String> str = new ArrayList<>();
        String[] ch = s.split("");
        for(int i = 0 ; i<ch.length;i++){
            str.add(ch[i]);
        }
        Comparator<String> comparator = new Comparator<>(){
          
            @Override
            public int compare(String c1, String c2){
                return c2.compareTo(c1) ;
            }
        };
        
        Collections.sort(str,comparator);
        for(int i = 0 ; i <str.size();i++){
            answer+=str.get(i);
        }
        return answer;
    }
}