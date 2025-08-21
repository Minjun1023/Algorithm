// p1 = 3, p2 = 1, p3 = 4, p4 = 3, p5 = 2
// 1. ex) [1,2,3,4,5]
// 3+(3+1)+(3+1+4)+(3+1+4+3)+(3+1+4+3+2) = 3+4+8+11+13 = 39 -> ??
// 2. ex) sort) [2,5,1,4,3]
// 1+(1+2)+(1+2+3)+(1+2+3+3)+(1+2+3+3+4) = 1+3+6+10+13 = 32 -> 최소

package baekjoon;

import java.util.*;
import java.io.*;
public class BOJ_11399 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        int add = 0;

        for (int i = 0; i < n; i++) {
            add += arr[i];
            sum += add;
        }
        System.out.println(sum);
    }
}
