package baekjoon;

import java.io.*;
import java.util.*;

/*
 * 5 2
 * 4 1 2 3 5
 * 2
 * 
 * 1 2 3 4 5
 */

public class BOJ_11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(arr, 0, n-1);
        System.out.println(arr[k-1]);
    }

    static void quicksort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotIndex = partition(arr, start, end);

        quicksort(arr, start, pivotIndex-1);
        quicksort(arr, pivotIndex+1, end);
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];

        int i = start + 1;
        int j = end;

        while (true) {
            while (i <= end && arr[i] < pivot) i++;
            while (j >= start + 1 && arr[j] > pivot) j--;

            if (i > j) break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, start, j);
        return j;
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
