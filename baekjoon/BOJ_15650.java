package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15650 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       arr = new int[m];
       dfs(1, 0);
       System.out.println(sb);
    }
    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int r : arr) {
                sb.append(r).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
    
}
