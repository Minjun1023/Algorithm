package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1018 {
    // 화이트, 블랙 구분
    public static boolean[][] arr;
    // 8 * 8 이므로 최대 64
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                // 화이트: 참
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                // 블랙: 거짓
                } else {
                    arr[i][j] = false;
                }
            }
        }
        
        // 8 * 8 로 자르기 위해 경우의 수 = n-7
        for (int i = 0; i < n-7; i++) {
            for (int j = 0; j < m-7; j++) {
                find(i, j);
            }
        }
        // 최솟값 출력
        System.out.println(min);
    }

    public static void find(int x, int y) {
        // 8 * 8로 자르기 위함
        int end_x = x + 8;
        int end_y = y + 8;
        int cnt = 0;

        // 첫 번째 블럭의 색깔
        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 첫 번째 블럭의 색깔과 다른 경우
                if (arr[i][j] != TF) {
                    cnt++;
                }
                // 색이 변경 되므로 boolean 값 변경
                TF = (!TF);
            }
            // 색이 변경 되므로 boolean 값 변경
            TF = !TF;
        }

        cnt = Math.min(cnt, 64-cnt);        
        min = Math.min(min, cnt);
    }
}
