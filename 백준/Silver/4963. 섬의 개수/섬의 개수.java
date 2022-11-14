import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public ArrayList<ArrayList<Integer>> graph;

    public int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1};
    public int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
    boolean[][] visited;

    public static void main(String[] args) throws IOException {

        Main solution = new Main();
        solution.solution();
    }

    public void solution() throws IOException {

        int w, h;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

                 if(w==0 && h==0){
                break;
            }
            //graph 초기화
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                graph.add(new ArrayList<>());
                for (int j = 0; j < w; j++) {
                    graph.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }
            visited = new boolean[h][w];
            //DFS 진행
            int ans = 0;
            for (int i = 0; i < h; i++) {

                for (int j = 0; j < w; j++) {
                    if (DFS(i, j, h, w)) {
                        ans++;
                    }
                }
            }
            System.out.println(ans);

        } while (w != 0 && h != 0);

    }

    public boolean DFS(int m, int n, int h, int w) {


        if (m < 0 || m >= h || n < 0 || n >= w) {
            return false;
        }
        if (graph.get(m).get(n) == 0) {
            visited[m][n] = true;
            return false;
        }
        if (!visited[m][n]) {
            visited[m][n] = true;
            for (int i = 0; i < 8; i++) {
                DFS(m + dx[i], n + dy[i], h, w);
            }
        } else {
            return false;
        }

        return true;
    }
}
