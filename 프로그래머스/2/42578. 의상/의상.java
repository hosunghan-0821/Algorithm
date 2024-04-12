import java.util.*;

class Solution {
    
    int answer = 1;
    
    public void combination(int[] array,boolean[] visited,int depth, int n,int r) {
        
        if (r == 0) {
            add(array, visited, n);
            return;
        }

        for (int i = depth; i < n; i++) {
            visited[i] = true;
            combination(array, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    public void add(int[] array, boolean[] visited, int n) {
        int sum =  1;
        
        for (int i = 0 ; i < n; i++ ) {
           
            if (visited[i]) {
                sum *= array[i];
            }
            
        }
        answer += sum;
    }
    
    public int solution(String[][] clothes) {
       
        HashMap<String,Integer> map = new HashMap<>();
   
        int row = clothes.length;
        for (int i = 0; i < row; i++) {
            String key = clothes[i][1];
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key,1);
            }
        }
     
        int[] lengthArray = new int[map.size()];
        int cnt = 0;
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            answer *= (entry.getValue() + 1);
    
        }
        
       
        
        return answer - 1;
    }
}