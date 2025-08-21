package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ_2468 {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int maxheight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] > maxheight) {
                    maxheight = map[i][j];
                }
            }
        }

        int max = 0;
        for (int height = 0; height < maxheight+1; height++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        cnt += bfs(i, j, height);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static int bfs(int x, int y, int height) {
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int px = pos[0];
            int py = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > height) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        } 
        return 1;
    }
}
