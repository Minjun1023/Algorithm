package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1715 {
    static int n;
    static int arr[];
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            q.add(a);
        }

        int result = 0;

        while (q.size() != 1) {
            int x = q.poll();
            int y = q.poll();

            int sum = x + y;
            result += sum;

            q.add(sum);
        }
        System.out.println(result);
    }
}
