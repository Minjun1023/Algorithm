package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2805 {
    static int n, m;
    static int[] arr;
    static int cutting;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = -1;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            long tree = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    tree += arr[i] - mid;
                }
            }
            if (tree >= m) {
                left = mid + 1;
            } else if (tree < m) {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
