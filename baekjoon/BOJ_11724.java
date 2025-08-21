package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11724 {
    static int N, M;
    static int[][] graph;
    static int u, v;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < M+1; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            u = Integer.parseInt(stk.nextToken());
            v = Integer.parseInt(stk.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }

        int result = 0;
        for (int j = 1; j < N+1; j++) {
            // 방문하지 않은 경우
            if (!visited[j]) {
                bfs(j);
                // 연결요소 1 추가
                result++;
            }
        }
        System.out.println(result);
    }

    public static void bfs(int node) {
        // 큐에 추가
        q.offer(node);
        // 방문처리
        visited[node] = true;

        while (!q.isEmpty()) {
            // 큐의 맨 앞에 있는 값을 temp 변수에 넣음
            int temp = q.poll();
            for (int i = 1; i < N+1; i++) {
                // 방문하지 않고, 그래프가 연결되어있는 경우
                if (!visited[i] && graph[temp][i] == 1) {
                    // 큐에 추가
                    q.offer(i);
                    // 방문 처리
                    visited[i] = true;
                }
            }
        }
    }
}
