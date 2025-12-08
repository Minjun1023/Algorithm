package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_7562 {
    static int n, I, x1, y1, x2, y2;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            I = Integer.parseInt(br.readLine());
            arr = new int[I][I];
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.offer(new int[] {x1, y1});
            visited[x1][y1] = true;

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];

                if (x == x2 && y == y2) break;

                for (int dir = 0; dir < 8; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                    if (visited[nx][ny]) continue;
                    
                    visited[nx][ny] = true;
                    arr[nx][ny] = arr[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
            sb.append(arr[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }
}
