import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer> list[];
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i : list[start]) {
            if (!visited[i]) {
                visited[i] = true;
                parent[i] = start;
                dfs(i);
            }
        }
    }
    
}
