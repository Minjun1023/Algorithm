package baekjoon;

import java.util.*;
import java.io.*;
public class BOJ_11286 {
        public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            // 절댓값 비교
            public int compare(Integer o1, Integer o2) {
                // 절댓값이 o1이 더 큰 경우
                if (Math.abs(o1) > Math.abs(o2)) {
                    // o2 출력
                    return Math.abs(o1) - Math.abs(o2);
                    // 절댓값이 같은 경우
                } else if (Math.abs(o1) == Math.abs(o2)) {
                    // 값이 작은 값 출력
                    return o1 - o2;
                    // 절댓값이 o2가 더 큰 경우
                } else {
                    // o1 출력
                    return -1;
                }
            }
        });
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                pq.offer(num);
            }
        }
    }
}
