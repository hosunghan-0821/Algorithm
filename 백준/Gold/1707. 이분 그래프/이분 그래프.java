import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static ArrayList<ArrayList<Integer>> graph =new ArrayList<ArrayList<Integer>>();;
    public static int N;
    public static int[] visited;

    public static boolean BFS(int x, int V) {


        ArrayList<Integer> groupA = new ArrayList<>();
        ArrayList<Integer> groupB = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(x);

        if(visited[x]!=0){
            return true;
        }
        visited[x] = 1;


        while (!queue.isEmpty() ) {


            int vertex = queue.poll();

            for (int adj : graph.get(vertex - 1)) {

                if(visited[adj]==0){
                    queue.offer(adj);
                }

                if (visited[vertex]==1) {
                    if (visited[adj]==1) {
                        return false;
                    }
                    visited[adj]=2;

                } else {
                    if (visited[adj]==2) {
                        return false;
                    }
                    visited[adj]=1;

                }
            }

        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ans;
        //전체 도는 횟수
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];


            ans="YES";
            //graph 초기화
            graph.clear();
            for (int k = 0; k < V; k++) {
                graph.add(new ArrayList<>());
            }

            //간선을 통해 graph 그리기
            for (int j = 0; j < E; j++) {

                StringTokenizer st_graph = new StringTokenizer(br.readLine(), " ");

                int start = Integer.parseInt(st_graph.nextToken());
                int end = Integer.parseInt(st_graph.nextToken());
                graph.get(start - 1).add(end);
                graph.get(end - 1).add(start);
            }
            //BFS를 통해 이분 그래프인지 확인

            for(int l = 1 ; l<=V;l++ ){
                if(!BFS(l, V)) {
                    ans="NO";
                    break;
                }
            }

            System.out.println(ans);

        }
    }
}
