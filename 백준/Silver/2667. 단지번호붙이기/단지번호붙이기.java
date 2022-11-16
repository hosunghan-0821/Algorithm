

import java.util.*;
import java.io.*;

public class Main {


    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        //graph세팅
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {

            graph.add(new ArrayList<>());
            String num_str_ary = br.readLine();

            for (int j = 0; j < N; j++) {
                graph.get(i).add(num_str_ary.charAt(j) - '0');
            }
        }

        int ans ;
        ArrayList<Integer> ans_ary = new ArrayList<>();
        for(int i = 0 ; i <N ; i++){
            for(int j = 0 ; j<N ; j++){
                ans=0;
                ans=DFS(i,j,ans);
                if(ans!=0){
                    ans_ary.add(ans);
                }
            }
        }
        Collections.sort(ans_ary);
        System.out.println(ans_ary.size());
        for(int i = 0 ; i<ans_ary.size();i++){
            System.out.println(ans_ary.get(i));
        }
    }

    static int DFS(int m, int n, int ans) {
        if (m < 0 || m >= N || n < 0 || n >= N) {
            return ans;
        }
        if (visited[m][n]) {
            return ans;
        }

        int vertex = graph.get(m).get(n);

        if (vertex == 1) {
            ans++;
            visited[m][n] = true;
        } else {
            visited[m][n] = true;
            return ans;
        }
        for (int i = 0; i < 4; i++) {
            ans = DFS(m + dx[i], n + dy[i], ans);
        }

        return ans;

    }

}
