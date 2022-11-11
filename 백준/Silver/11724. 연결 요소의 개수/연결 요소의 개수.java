import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static LinkedList<Integer>[] graph;
    public static boolean visited[];
    public static int count=0;
    public static int result = 0 ;

    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <=N ; i ++){
            graph[i]=new LinkedList<>();
        }

        for(int i = 0 ; i<M; i++){

            st= new StringTokenizer(br.readLine()," ");
            int start =Integer.parseInt(st.nextToken());
            int end  = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i =1 ; i<=N ; i++){
            if(!visited[i]){
                result++;
                DFS(i);

            }
        }

        System.out.println(result);

    }
    public static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v]=true;
        for(int vertex : graph[v]){
            DFS(vertex);
        }
        count++;
    }

}