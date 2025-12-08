package baekjoon;

import java.io.*;
import java.util.*;
public class BOJ_1012 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    static int m, n, k;
    static int x, y;
    static boolean[][] visited;
    static int[][] map;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }                
                }
            }
            sb.append(cnt + "\n");
            cnt = 0;
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
    }    
}    
