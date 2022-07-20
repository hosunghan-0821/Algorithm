import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Integer> arr = new ArrayList<>();
        String[] s_list = s.split(" ");
        for(int i = 0 ;i<s_list.length;i++){
            arr.add(Integer.parseInt(s_list[i]));
        }
        Collections.sort(arr);
        answer = arr.get(0)+" "+arr.get(arr.size()-1);
        return answer;
    }
}