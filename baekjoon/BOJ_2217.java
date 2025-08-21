// 2
// 10, 15 -> 15, 10
// 1.15, 2.10*2=20

// 4
// 30, 25, 20, 10
// 1.30, 2.25*2=50, 3.20*3=60, 4.10*4=40

package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2217 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int total = 0;
        for (int i = 0; i < N; i++) {
            total = Math.max(total, arr[i] * (i+1));
        }
        System.out.println(total);
    }
    
}
