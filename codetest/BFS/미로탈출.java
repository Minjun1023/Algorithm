package codetest.BFS;

import java.util.*;
import java.io.*;

public class 미로탈출 {
    public static int n, m;
    public static int graph[][];
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static Queue<Pair> queue = new LinkedList<>();

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y) {

        queue.add(new Pair(x, y));

        while(!queue.isEmpty()) {

            Pair pair = queue.poll();
            x = pair.x;
            y = pair.y;

            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= m)
                    continue;

                if (graph[next_x][next_y] == 1){
                    graph[next_x][next_y] = graph[x][y] + 1;
                    queue.add(new Pair(next_x, next_y));
                }
            }
        }
        return graph[n-1][m-1];
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0,0));
    }
    
}
