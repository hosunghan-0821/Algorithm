import java.util.*;

class Solution {
    
    public Set<Integer> data = new HashSet<>();
    
    public int solution(String numbers) {
        
        int answer = 0;
        dfs(numbers,new boolean[numbers.length()],new StringBuilder());
     
        
        for (Integer num : data) {
            if(num<2) continue;
            if (isPrimeNumber(num)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public void dfs(String numbers, boolean[] visited ,StringBuilder s){
        
        for(int i = 0 ; i <numbers.length();i++){
            if(visited[i])continue;
            s.append(numbers.charAt(i));
            visited[i]=true;
            data.add(Integer.parseInt(s.toString()));
            dfs(numbers,visited,s);
            s.deleteCharAt(s.length()-1);
            visited[i]=false;
        }
       
    }

    public boolean isPrimeNumber(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}