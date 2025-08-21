package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2579 {
    static int n;
    static int[] arr;

    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) { dp[1] = arr[1]; }
        else if (n == 2) { dp[2] = arr[1] + arr[2]; }
        else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], arr[i-1] + dp[i-3]) + arr[i];
            }
        }
        System.out.println(dp[n]);
    }
} 
