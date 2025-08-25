package baekjoon;

import java.io.*;
import java.util.*;
/*
 * 7
 * max(7+3, 7+8)
 * max(10+8, 10+1), max(15+1, 15+0)
 * max(18+2, 18+7), max(16+7, 16+4)
 * max(25+5, 25+2), max(23+5, 23+2)
 * max(30, 27, 28, 25) = 30
 */
public class BOJ_1932 {
    static int n;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        dp = new int[n][n];

        // 0~999이므로 계산되지 않은 것은 -1로 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];  
        }

        System.out.println(find(0,0));
    }

    public static int find(int depth, int idx) {
        if (depth == n-1) return dp[depth][idx];

        if (dp[depth][idx] == -1) {
            dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }
}
