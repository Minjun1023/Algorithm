package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1912 {
    static int n;
    static int max;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 음의 값 조건 -> max값 = arr[0]
        dp[0] = arr[0];
        max = arr[0];

        for (int i = 1; i < n; i++) {
            // 이전의 값과 현재의 값을 더한 값이 현재의 값중 더 큰 값을 선택
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            // 최대값 갱신
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
