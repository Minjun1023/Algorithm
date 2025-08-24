// 1. 카운팅 정렬
// 2. 정렬 후 뒤에서부터 출력
package baekjoon;

import java.util.*;
import java.io.*;
public class BOJ_1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (N > 0) {
            arr[N % 10]++;  // arr[3] = 1, arr[4] = 1, arr[1] = 1, arr[2] = 1
            N /= 10;    // 214, 21, 2, 0
        }

        for (int i = arr.length-1; i>=0; i--) {
            while (arr[i] --> 0) {
                System.out.print(i);
            }
        }
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // char[] arr = br.readLine().toCharArray();

        // Arrays.sort(arr);

        // for (int i = arr.length-1; i >= 0; i--) {
        //     System.out.print(arr[i]);
        // }
    }
}
