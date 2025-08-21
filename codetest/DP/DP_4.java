package codetest.DP;

import java.io.*;
import java.util.*;

public class DP_4 {
    static int n, m;
    static int[] arr;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        d = new int[m+1];
        Arrays.fill(d, 10001);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <=m; j++) {
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j-arr[i]] + 1);
                }
            }
        }
        if (d[m] == 10001) System.out.println(-1);
        else System.out.println(d[m]);
    }
}