package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2606 {
    
    static int a,b,v;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static int bfs(int node) {
       queue.add(node);
       visited[node] = true;
       while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j=1; j <= a; j++) {
                if (graph[temp][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                    cnt++;
                }
            }
       }
       return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        v = 1;

        graph = new int[a+1][a+1];

        for (int i = 1; i <=b; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            graph[n][m] = graph[m][n] = 1;
        }

        visited = new boolean[a+1];

        System.out.println(bfs(1));        
    }
    
}
