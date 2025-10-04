package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14467 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] check = new int[n+1];
        for (int i = 1; i <= n; i++) {
            check[i] = -1;
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            if (check[num] == -1) {
                check[num] = location;
            } else if (check[num] != location) {
                total++;
                check[num] = location;
            }
        }
        System.out.println(total);
    }
    
}
