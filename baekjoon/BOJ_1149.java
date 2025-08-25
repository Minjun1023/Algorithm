package baekjoon;

import java.io.*;
import java.util.*;

/*
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
 * 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어짐.
 * 규칙 1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다 2. N번 집의 색은 N-1번 집의 색과 같지 않아야 한다 3. i(2<=i<=N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 * 모든 집을 칠하는 비용의 최솟값을 출력한다.
 * dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2])
 * dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2])
 * dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1])
 */
public class BOJ_1149 {
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        // 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 점화식
        for (int i = 1; i < N; i++) {
            cost[i][0] = cost[i][0] + Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] = cost[i][1] + Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] = cost[i][2] + Math.min(cost[i-1][0], cost[i-1][1]);   
        }
        // 최소 비용 출력
        System.out.println(Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2])));
    }
}
