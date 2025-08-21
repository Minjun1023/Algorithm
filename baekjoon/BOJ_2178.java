package baekjoon;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class BOJ_2178 {

    static int n, m;
    static int graph[][];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();

    public static void bfs(int x, int y) {
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point curPoint = q.poll();
            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];
                
                // 지나갈 수 없는 경우 3가지
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                if (graph[nextX][nextY] == 0)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                // 통과가능할경우 큐에 추가
                q.offer(new Point(nextX, nextY));
                // 방문처리
                visited[nextX][nextY] = true;

                // 지나갔을 경우 거리 값 측정
                graph[nextX][nextY] = graph[curPoint.x][curPoint.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = s.charAt(j) - '0'; // 1,0 값 측정
            }
        }

        bfs(0,0); // 출발지점

        System.out.println(graph[n-1][m-1]); 
    }
}
