package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2630 {
    static int N;
    static int[][] map;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (map[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        
        int newSize = size / 2;
        partition(row, col, newSize);   // 왼쪽 위
        partition(row, col+newSize, newSize);   // 오른쪽 위
        partition(row+newSize, col, newSize);   // 왼쪽 아래
        partition(row+newSize, col+newSize, newSize);   // 오른쪽 아래
    }
    
    public static boolean colorCheck(int row, int col, int size) {
        int color = map[row][col];

        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
