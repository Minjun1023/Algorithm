package baekjoon;

import java.io.*;
import java.util.*;

// 토마토 MxN M=가로, N=세로
// 익은 토마토는 익지 않은 토마토들에게 영향을 준다. -> 상하좌우
// 창고에 보관된 토마토들이 몇일이 지나면 다 익는지 최소 일수 출력
// 상자의 일부 칸에는 토마토가 들어있지 않을 수 있다.
public class BOJ_7576 {
    static int M, N;
    static boolean[][] visited;
    static int[][] map; 
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<tomato> q = new LinkedList<>();

    static class tomato {
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 && !visited[i][j]) {
                    q.offer(new tomato(i, j, 0));
                }
            }
        }
        bfs();
   }
   public static void bfs() {
        int day = 0;

        while (!q.isEmpty()) {
            tomato t = q.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.add(new tomato(nx, ny, day+1));
                    }
                }
            }
        }
        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
   }

   static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    return false;
            }
        }
        return true;    
   }
}
