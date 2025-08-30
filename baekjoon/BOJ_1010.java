package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1010 {
    static int T;
    static int N, M;
    static int[][] dp = new int[30][30];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            sb.append(combi(M, N)).append('\n');
        } 

        System.out.println(sb);
    }
    static int combi(int n, int r) {

        // 이미 계산이 되어있으면 재귀x
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // nCn = nC0 = 1
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // nCr = (n-1)Cr + (n-1)C(r+1)
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
    
}
