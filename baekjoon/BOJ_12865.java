package baekjoon;

import java.io.*;
import java.util.*;
/*
    0   1   2   3   4   5   6   7  
0   0   0   0   0   0   0   0   0
1   0   0   0   0   0   0   13  13
2   0   0   0   0   8   8   13  13
3   0   0   0   6   8   8   13  14
4   0   0   0   6   8   12  13  14

*  4 7
   6 13
   4 8
   3 6
   5 12
*/

public class BOJ_12865 {

    static Integer[][] dp;
    static int[] W; // 무게
    static int[] V; // 가치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물품의 수
        int K = Integer.parseInt(st.nextToken());   // 무게

        W = new int[N];
        V = new int[N];

        dp = new Integer[N][K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N-1, K));
    }

    static int knapsack(int i, int k) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][k] == null) {
            // 무게를 버티지 못해서 물건을 담을 수 없는 경우
            if (W[i] > k) {
                dp[i][k] = knapsack(i-1, k);
            }
            // 물건을 담을 수 있는 경우
            else {
                // 담지 않는 경우와 담는 경우 값을 비교해서 더 큰 값을 저장
                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }
}
