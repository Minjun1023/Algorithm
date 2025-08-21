package codetest.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특정수의개수 {
    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = leftIndex(0, n);
        int right = rightIndex(0, n);

        System.out.println(right - left == 0 ? -1: right - left);
    }

    private static int leftIndex(int start, int end) {
        while (start <  end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= x) end = mid;
            else start = mid + 1;
        }   
        return end;
    }

    private static int rightIndex(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > x) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
