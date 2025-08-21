package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15486 {

    static int n;
    static int[] time;
    static int[] pay;
    static int[] dp;
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n+2];
        pay = new int[n+2];
        dp = new int[n+2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n+1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            int day = i + time[i];
            if (day <= n+1) {
                dp[day] = Math.max(dp[day], max + pay[i]);
            }
        }
        System.out.println(max);
    }
}


