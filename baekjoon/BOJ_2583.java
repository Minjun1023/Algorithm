package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2583 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int m, n, k;
    static int[][] map;
    static int size;
    static ArrayList<Integer> result;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    size = 1;
                    dfs(i, j);
                    result.add(size);
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size() + "\n");

        for (int r : result) {
            sb.append(r + " ");
        }

        System.out.print(sb);
    }

    public static void dfs(int y, int x) {
        map[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[ny][nx] == 0) {
                size ++;
                dfs(ny, nx);
            }
        }
    }
    
}
