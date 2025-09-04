package baekjoon;

import java.io.*;
import java.util.*;

/*
 *   1 2 3 4
 * 1 0 1 1 1
 * 2 1 0 0 1
 * 3 1 0 0 1  
 * 4 1 1 1 0
 */
public class BOJ_1260 {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) dfs(i);
        }
    }
    
    static void bfs(int node) {
        q.add(node);
        visited[node] = true;
        System.out.print(node + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
