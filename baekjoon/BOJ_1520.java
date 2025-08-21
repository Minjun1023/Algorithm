package baekjoon;
import java.io.*;
import java.util.*;

public class BOJ_1520 {
    static int m,n;
    static int graph[][];
    static int dp[][];
    static int dx[] = {-1 ,1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        // 도착 지점에 도달했을 경우
        if (x == m-1 && y == n-1) return 1;
        // 방문한 적이 없는 경우
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            // 상하좌우 방향
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 지정
                if (nx < 0 || nx > m-1 || ny < 0 || ny > n-1) continue;
                // 내리막 길인 경우
                if (graph[x][y] > graph[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}