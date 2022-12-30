import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i< numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                
                return -Integer.compare(Integer.parseInt(s1+s2),Integer.parseInt(s2+s1));
            }
        });
        StringBuilder s = new StringBuilder();
        for(int i = 0 ; i < list.size();i++){
        
            s.append(String.valueOf(list.get(i)));
        }
        if(s.toString().charAt(0)=='0'){
            return "0";
        }
        return s.toString();
    }
}