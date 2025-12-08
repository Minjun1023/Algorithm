package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1743 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, k, cnt, ans;
    static boolean[][] map;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = true;
        }

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= m; k++) {
                if (!visited[j][k] && map[j][k]) {
                    cnt = 0;
                    bfs(j, k);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        cnt++;
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

                if (!visited[nx][ny] && map[nx][ny]) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
    }    
}
