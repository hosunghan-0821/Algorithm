import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> array_list = new ArrayList<>();
        //ArrayList로 배열 이동.
        for(int i = 0 ; i <array.length;i++){
            array_list.add(array[i]);
        }
        int j = 0 ;
        for(int[] command: commands){
            answer[j]=get_condition_num(array_list,command[0],command[1],command[2]);
            j++;
        }
        
        return answer;
    }
    public int get_condition_num(ArrayList<Integer> array, int start, int end, int k){
        //System.out.println("start : "+start + " end : "+end+" k : "+k );
        ArrayList<Integer> condition_array = new ArrayList<>();
        for(int i = start -1 ; i<=end-1;i++){
            condition_array.add(array.get(i));
        }
        Collections.sort(condition_array);
        for(int i = 0 ; i< condition_array.size();i++){
            //System.out.println(condition_array.get(i));
        }
        //return 0;
        return condition_array.get(k-1);
    }
}