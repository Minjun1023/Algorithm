package codetest.정렬;

import java.io.*;
import java.util.*;

public class 두배열의원소교체 {
    static int n, k;
    static int[] arr;
    static Integer[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        arr2 = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2, Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (arr[i] < arr2[i]) {
                int temp = arr[i];
                arr[i] = arr2[i];
                arr2[i] = temp;
            }
            else break;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
