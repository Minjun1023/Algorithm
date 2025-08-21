package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1026 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        // 내림차순 정렬을 위해 int가 아닌 Integer로 선언
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        // A 배열은 오름차순, B 배열은 내림차순으로 정렬
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += (A[i] * B[i]);
        }
        System.out.println(sum);
    }
    
}
