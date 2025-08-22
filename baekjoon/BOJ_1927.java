package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1927 {
    static int N;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 0보다 큰 경우 값 추가
            if (num > 0) {
                q.add(num);
            } else {
                // 0인경우 비어있으면 0출력, 비어있지 않으면 가장 작은 값 출력
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }
            }
        }
    }
