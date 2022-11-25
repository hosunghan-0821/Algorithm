class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        int[][] map = new int[rows][columns];
        
        //초기화
        int num=1;
        for(int i = 0 ;i<rows;i++){
            for(int j = 0; j<columns ; j++){
                map[i][j]=num;
                num++;
            }
        }

        for(int i =0; i< queries.length;i++){
        
            int r1 =queries[i][0];
            int c1= queries[i][1];
            
            int r2 = queries[i][2];
            int c2 = queries[i][3];
   
            int r= r1;
            int c= c1;
            int swap_after;
            int swap_before= map[r-1][c-1];
            int min = map[r-1][c-1]; 
            
            
            for(int j= 0 ;j<c2-c1;j++){
                
                c=c+1;
                swap_after = map[r-1][c-1];
                if(min>swap_after){
                    min=swap_after;
                }
                map[r-1][c-1]=swap_before;
                swap_before=swap_after;
            }
            for(int j = 0 ; j < r2-r1;j++){
                r=r+1;
                swap_after = map[r-1][c-1];
                if(min>swap_after){
                    min=swap_after;
                }
                map[r-1][c-1]=swap_before;
                swap_before=swap_after;
            }
            for(int j = 0 ; j<c2-c1;j++){
                c=c-1;
                swap_after = map[r-1][c-1];
                if(min>swap_after){
                    min=swap_after;
                }
                map[r-1][c-1]=swap_before;
                swap_before=swap_after;
            }
            for(int j = 0 ; j < r2-r1;j++){
                r=r-1;
                swap_after = map[r-1][c-1];
                if(min>swap_after){
                    min=swap_after;
                }
                map[r-1][c-1]=swap_before;
                swap_before=swap_after;
            }
            answer[i]=min;
            
        
        }
        return answer;
    }
}