package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14620 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int cost) {
        if (depth == 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (visited[i][j]) continue;
                boolean flag = true;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (visited[nx][ny]) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) continue;

                int sum = arr[i][j];
                visited[i][j] = true;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    sum += arr[nx][ny];
                    visited[nx][ny] = true;
                }

                dfs(depth+1, sum+cost);

                visited[i][j] = false;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    visited[nx][ny] = false;
                }
            }
        }
    }
    
}
