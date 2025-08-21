package baekjoon;

import java.io.*;
import java.util.*;
/*
 * 3 
 * 4
 * 7
 * 10
 */
public class BOJ_9095 {
    static int t, n;
    static int[] d = new int[11];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i < 11; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
    
}
