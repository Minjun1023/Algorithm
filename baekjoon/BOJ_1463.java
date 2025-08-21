package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1463 {
    static int n;
    static int[] d = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            d[i] = d[i-1] + 1;

            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
        }
        System.out.println(d[n]-1);
    }
}


