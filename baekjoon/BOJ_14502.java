package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14502 {
    static class Node {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static int maxSafeZone = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }
    static void dfs(int wallcnt) {
        // 벽이 3개가 설치된 경우 바이러스 퍼트리기 위해 bfs 탐색
        if (wallcnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallcnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }
        
        int copyArr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyArr[i] = arr[i].clone();    
        }

        while (!q.isEmpty()) {
            // 현재 위치: 바이러스
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            // 상하좌우
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 조건
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    // 0일 경우 2로 변경(바이러스 확산)
                    if (copyArr[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        copyArr[nx][ny] = 2;
                    }
                }
            }
        }

        //safeZone 확인
        funcSafeZone(copyArr);
    }
    
    private static void funcSafeZone(int[][] copyArr) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 0인 경우 안전구역
                if (copyArr[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
        }
    }
}


