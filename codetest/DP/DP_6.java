package codetest.DP;

import java.io.*;
import java.util.*;

// 7
// 15 11 4 8 5 2 4

public class DP_6 {
    static int n;
    static ArrayList<Integer> lst = new ArrayList<>();
    static int[] dp = new int[2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }

        Collections.reverse(lst); // 4 2 5 8 4 11 15

        // dp 테이블 초기화
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lst.get(j) < lst.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}
