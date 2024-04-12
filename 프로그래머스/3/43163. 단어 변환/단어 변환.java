class Solution {
    
    public int answer = Integer.MAX_VALUE;
    
    public void dfsRecursive
        (int index,String target, String[] words, boolean[] visited,int count) {
        String word = words[index];
        
        if (word.equals(target)) {
            if (count < answer) {
                System.out.println(count);
                answer = count;
            }
            return;
        }
        
        for (int i = 0 ; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (checkOneAlphabetChanged(word,words[i])) {
        
                visited[i] = true;
                dfsRecursive(i,target,words,visited,count + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean checkOneAlphabetChanged(String s1, String s2) {
        
        boolean isChanged = false;
        int count = 0;
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0 ; i <s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                break;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
    public int solution(String begin, String target, String[] words) {
    
        
        boolean[] visited = new boolean[words.length];
        for (int i = 0 ; i < words.length; i++) {
            if (checkOneAlphabetChanged(begin,words[i])) {
  
                visited[i] = true;
                dfsRecursive(i,target,words,visited,1);
            }
        }
        
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        
        return answer;
    }
}