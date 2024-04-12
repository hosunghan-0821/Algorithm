import java.util.*;

class Solution {
    
    public int totalRow = 0;
    public int totalColumn = 0;
    
    public int bfs(int[][] maps, boolean[][] visited) {
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
       
        while(!queue.isEmpty()) {
            int[] data = queue.poll();
            if (maps[data[0]][data[1]] == 0 || visited[data[0]][data[1]] ==true) {
                continue;
            }
            maps[data[0]][data[1]] = data[2];
            visited[data[0]][data[1]] = true;
            for (int i = 0 ; i < 4; i++) {
                
                int new_row = data[0] + dy[i];
                int new_column = data[1] + dx[i];
                
                if (new_row < 0 || new_row >= totalRow || new_column < 0 || new_column >= totalColumn) {
                    continue;
                }
                queue.add(new int[]{new_row, new_column, data[2] + 1});
            }

        }
        
        if (maps[totalRow - 1][totalColumn - 1] == 1) {
            return -1;
        } else {
            return maps[totalRow - 1][totalColumn - 1];
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;

        totalRow = maps.length;
        totalColumn = maps[0].length;
        boolean[][] visited = new boolean[totalRow][totalColumn];
        
        answer = bfs(maps,visited);
        
        
        return answer;
    }
}