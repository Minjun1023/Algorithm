package baekjoon;

import java.io.*;
import java.util.*;
/*
 * 6
 * 6,10,13,9,8,1 - 33
 * 6,10 9,8
 * 
 * OOX
 * OXO
 * XOO
 * 
 * dp[1] = wine[1]
 * dp[2] = wine[1]+wine[2]
 * dp[3] = Math.max(dp[3-1], Math.max(dp[3-2]+wine[3], dp[3-3]+wine[2]+wine[3])
 * dp[4] = Math.max(dp[4-2]+wine[4], dp[4-3]+wine[3]+wine[4])
 * dp[5] = Math.max(dp[5-1], Math.max(dp[5-3]+wine[4]+wine[5], wine[2]+wine[3]+wine[5])
 * dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i])
 */

public class BOJ_2156 {
    static int n;
    static int[] wine;
    static int[] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        wine = new int[n+1];
        dp = new int[n+1];
        for (int i=1; i<n+1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            if (i == 1) {
                dp[i] = wine[i];
            } else if (i == 2) {
                dp[i] = wine[i-1]+wine[i];
            } else {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
            }
        }
        System.out.println(dp[n]);
    }
}
