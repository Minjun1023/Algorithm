package baekjoon;

import java.io.*;
import java.util.*;

/*
 * 1 2 3 5 7 9 10 11 12
 */
public class BOJ_3273 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt = n;
        int sum = 0;
        int cnt = 0;
        while (lt < rt) {
            sum = arr[rt] + arr[lt];

            if (sum == x) cnt++;
            if (sum < x) {lt++;}
            else rt--;
            }
            System.out.println(cnt);
        }
}
