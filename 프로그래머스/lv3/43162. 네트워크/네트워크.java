import java.util.*;
import java.io.*;
class Solution {
    
    public ArrayList<ArrayList<Integer>> graph ;
    
    public int solution(int n, int[][] computers) throws IOException{

        graph = new ArrayList<>();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N =n;
        boolean []  visited = new boolean[N];

        //Graph 만들기
        for(int i = 0; i< N ; i ++){
            graph.add(new ArrayList<>());
            for(int  j = 0 ; j < N ; j ++){
                if(j == i)continue;
                else if(computers[i][j]==1)graph.get(i).add(j);
            }
        }
        for(int i = 0 ; i< N ; i++){
            if(dfs(i,visited)) answer ++;
        }

        return answer;
    }
    
    public boolean dfs(int vertex,boolean[] visited){
        if(visited[vertex]){
            return false;
        }
        visited[vertex]=true;

        for(int i = 0 ; i < graph.get(vertex).size();i++){
            dfs(graph.get(vertex).get(i),visited);
        }
        return true;
    }
}