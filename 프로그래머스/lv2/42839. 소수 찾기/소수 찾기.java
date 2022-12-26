import java.util.*;

class Solution {
    
    public Set<Integer> data = new HashSet<>();
    
    public int solution(String numbers) {
        
        int answer = 0;
        dfs(numbers, new boolean[numbers.length()], 0, new StringBuilder());
        System.out.println(data.size());
        for (Integer num : data) {
            if(num<2) continue;
            if (isPrimeNumber(num)) {
                answer++;
            }
        }
        
        
        return answer;
    }

    public boolean isPrimeNumber(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
      public void dfs(String numbers, boolean[] visited, int depth, StringBuilder s) {

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            s.append(numbers.charAt(i));

            data.add(Integer.parseInt(s.toString()));
            dfs(numbers, visited, depth + 1, s);

            s.deleteCharAt(s.length() - 1);
            visited[i] = false;
        }

    }


}