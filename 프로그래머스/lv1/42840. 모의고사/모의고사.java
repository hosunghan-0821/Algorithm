import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        ArrayList<Integer> first_member = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> second_member = new ArrayList<>(Arrays.asList(2,1,2,3,2,4,2,5));
        ArrayList<Integer> third_member = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        
        Integer fir_count=0,sec_count=0,thr_count=0;
        for(int i = 0 ; i <answers.length;i++){
            if(first_member.get(i%5) ==answers[i]){
                fir_count++;
            }
            if(second_member.get(i%8)==answers[i]){
                sec_count++;
            }
            if(third_member.get(i%10)==answers[i]){
                thr_count++;
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,fir_count);
        map.put(2,sec_count);
        map.put(3,thr_count);
        
        
        ArrayList<Integer> answer_list = new ArrayList<>();
        Integer max_value= Collections.max(map.values());
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();

        for(Map.Entry<Integer,Integer> entry: entrySet ){
            if(entry.getValue().equals(max_value)){
                answer_list.add(entry.getKey());
            }
        }
        Collections.sort(answer_list);
        int[] answer = new int[answer_list.size()];
        for(int i = 0 ; i<answer_list.size();i++){
            answer[i]=answer_list.get(i);
        }
        // System.out.println(fir_count);
        // System.out.println(sec_count);
        // System.out.println(thr_count);
        return answer;
    }
}