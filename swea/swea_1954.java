package swea;
import java.io.*;
import java.util.*;

public class swea_1954 {
    // 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] nums = new int[N][N];
            int x = 0;
            int y = 0;
            int d = 0;
            int cnt = 1;
            while (cnt <= N*N) {
                nums[x][y] = cnt++;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || nums[nx][ny] != 0) {
                    d = (d+1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }

            System.out.println("#" + test_case);

            for (int[] arr : nums) {
                for (int i : arr) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

    }
    
}
