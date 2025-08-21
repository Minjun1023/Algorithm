package baekjoon;

import java.io.*;
import java.util.*;
/*
 * 4
 * -1
 * 2
 * 1
 * 3
 * -1+1+(2*3) = 6
 * 
 * 6
 * 0
 * 1
 * 2
 * 4
 * 3
 * 5
 * (5*4)+(3*2)+1+0 = 27
 * 
 * 1
 * -1
 * = -1
 * 
 * 3
 * -1
 * 0
 * 1
 * (-1*0)+1 = 1
 * 
 * 2
 * 1
 * 1
 * 1+1 = 2
 */

public class BOJ_1744 {
    static int N;
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minus = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());      

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }
        /*
         * minus: [-1] [-1,0]
         * plus: [3,2,1] [1]
         */
        int answer = 0;
        while (!minus.isEmpty()) {
            int cur = minus.poll();
            if (minus.isEmpty()) {
                answer += cur;
                break;
            }
            if (minus.peek() == 0) {
                minus.poll();
            } else {
                answer += cur * minus.poll();
            }
        }
        while (!plus.isEmpty()) {
            int cur = plus.poll();
            if (plus.isEmpty()) {
                answer += cur;
                break;
            }

            if (cur == 1) {
                answer += 1;
            } else if (plus.peek() == 1) {
                answer += cur + plus.poll();
            } else {
                answer += cur * plus.poll();
            }
        }
        System.out.println(answer);
    }

}   


