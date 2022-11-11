import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static int N, M, V;


    public static boolean[] visited;
    public static LinkedList<Integer>[] adj;
    public static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //문제 조건에 맞게 Graph 그리기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for (int i = 1; i <= M; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }
        //ADJ 오름차순으로 정렬해야함

        for (int i = 1; i <= N; i++) {
           Collections.sort(adj[i]);
        }

        //BFS ,DFS 작성해야함
        DFS(V);
        visited = new boolean[N+1];
        System.out.println();
        BFS(V);
    }

    /*
     * DFS 재귀적 방식으로 구현
     * Params : 시작 정점 v
     * */
    public static void DFS(int v) {
        // 방문한

        if(visited[v]){
            return ;
        }
        visited[v]=true;
        System.out.print(v+" ");
        for(int vertex :adj[v]){
            DFS(vertex);
        }
    }

    public static void BFS(int v){
        queue=new LinkedList<>();

        queue.offer(v);
        while(!queue.isEmpty()){
            int vertex =queue.poll();

            // 방문한 정점이라면 다음 정점이동
            if(visited[vertex]){
                continue;
            }
            // 방문한 정점이 아니라면, 방문처리를 함.
            visited[vertex]=true;
            System.out.print(vertex+" ");
            for(int newV : adj[vertex]){
                queue.offer(newV);
            }

        }
    }
}
