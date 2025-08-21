package baekjoon;

import java.io.*;
import java.util.*;

// M: 상자 가로 칸의 수
// N: 상자 세로 칸의 수
// H: 쌓아 올려지는 상자의 수
// 2 <= M <= 100, 2 <= N <= 100, 1 <= H <= 100
// 모든 토마토가 익어있는 경우 0을 출력
// 모든 토마토가 익지 못하는 경우 -1을 출력

public class BOJ_7569 {
    static int m, n, h;
    static int[][][] box;
    static int[] rowArr = {-1, 0, 1, 0, 0, 0};
    static int[] colArr = {0, 1, 0, -1, 0, 0};
    static int[] heightArr = {0, 0, 0, 0, 1, -1};
    static Queue<PointXYZ> q = new LinkedList<>();

    static class PointXYZ {
        int height;
        int row;
        int col;

        public PointXYZ(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            PointXYZ point = q.poll();

            int height = point.height;
            int row = point.row;
            int col = point.col;

            for (int i = 0; i < 6; i++) {
                int moveHeight = height + heightArr[i];
                int moveRow = row + rowArr[i];
                int moveCol = col + colArr[i];

                if (checkPoint(moveHeight, moveRow, moveCol)) {
                    q.add(new PointXYZ(moveHeight, moveRow, moveCol));
                    box[moveHeight][moveRow][moveCol] = box[height][row][col] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (box[i][j][k] == 0) return -1;
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
        if (result == 1) return 0;
        else return (result-1);
    }

    static boolean checkPoint(int height, int row, int col)  {
        if (height < 1 || height > h || row < 1 || row > n || col < 1 || col > m) return false;
        if (box[height][row][col] == 0) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h+1][n+1][m+1];

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) q.add(new PointXYZ(i, j ,k));
                }
            }
        }
    }
}
