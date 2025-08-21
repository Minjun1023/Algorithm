package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1260 {

    static int n, m ,v;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int j = 1; j <=n; j++) {
            if(graph[node][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs(int node) {
        queue.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int k = 1; k <= n; k++) {
                if (graph[temp][k] == 1 && !visited[k]) {
                    queue.add(k);
                    visited[k] = true;
                    System.out.print(k + " ");
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());

        graph = new int[n+1][n+1];

        for (int i = 1; i <= m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);

        System.out.println();

        visited = new boolean[n+1];
        bfs(v);


    }

}