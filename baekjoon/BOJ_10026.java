package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static String a;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            a = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = a.charAt(j);
            }
        }

        // 정상
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        cnt = 0;
        visited = new boolean[n][n];

        // 비정상
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        System.out.println(normal_cnt + " " + abnormal_cnt);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char tmp_char = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                if (arr[nx][ny] == tmp_char) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
