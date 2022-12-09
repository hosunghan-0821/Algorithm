import java.util.*;

class Solution {
    
    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    public int r, c;
    
    public int solution(int[][] maps) {

        r = maps.length;
        c = maps[0].length;
        boolean[][] visited = new boolean[r][c];

        return bfs(maps,visited);
    }
        public int bfs(int[][] maps, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0,0,1});
        int answer = -1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if(point[0]==r-1 && point[1]==c-1){
                answer = point[2];
                break;
            }

            for(int i = 0 ; i < 4 ; i ++){
                int nr = point[0]+dx[i];
                int nc = point[1]+dy[i];

                if(nr<0 || nr >= r || nc<0 ||nc>=c ){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }
                if(maps[nr][nc]==1){
                    queue.add(new int[]{nr,nc,point[2]+1});
                    visited[nr][nc]=true;
                }
            }


        }
        return answer;
    }
}