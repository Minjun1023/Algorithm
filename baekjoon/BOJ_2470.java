package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2470 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int gap = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        int temp;
        int sum;
        
        while (left < right) {
            sum = arr[left] + arr[right];
            temp = Math.abs(sum);
            if (temp < gap) {
                gap = temp;
                ans1 = arr[left];
                ans2 = arr[right];
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
