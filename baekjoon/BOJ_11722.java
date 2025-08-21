package baekjoon;

import java.io.*;
import java.util.*;
/*
 * 6
 * 10 30 10 20 20 10
 */

public class BOJ_11722 {
    static int n;
    static int[] arr;
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            /*
             * dp[0],dp[1] ... dp[5] = 1
             */
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    /*
                     * dp[1] = 1, dp[0]+1 = 2
                     * dp[1] = 2
                     */
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            /*
             * 1 1 2 2 2 3
             */
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
