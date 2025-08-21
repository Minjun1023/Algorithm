package codetest.DP;

import java.io.*;
import java.util.*;

// dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1])  

public class DP_5 {
    static int t;
    static int n, m;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            dp = new int[n][m];   

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = arr[i][j];
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, leftDown, left;
                    if (i == 0) leftUp = 0;
                    else leftUp = dp[i-1][j-1];
                    if (i == n-1) leftDown = 0;
                    else leftDown = dp[i+1][j-1];
                    left = dp[i][j-1];
                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[i][m-1]);
            }
            System.out.println(max);
        }
    }
}
