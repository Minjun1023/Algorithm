package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> deq = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String input = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[], ");

            for (int i = 0; i < n; i++) {
                deq.add(Integer.parseInt(st.nextToken()));
            }

            AC(input, deq);
        }
        
        System.out.println(sb);
        }

        public static void AC(String input, Deque<Integer> deq) {
            boolean isRight = true;

            for (char cmd : input.toCharArray()) {
                if (cmd == 'R') {
                    // 반대방향(뒤집기)
                    isRight = !isRight;
                    continue;
                }
                // 'D'이면서 정방향인 경우
                if (isRight) {
                    if (deq.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
                // 'D'이면서 반대방향인 경우
                else {
                    if (deq.pollLast() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
            makePrintString(deq, isRight);
        }

        public static void makePrintString(Deque<Integer> deq, boolean isRight) {
            sb.append('[');
            if (deq.size() > 0) {
                // 정방향인경우
                if (isRight) {
                    sb.append(deq.pollFirst());
                    while (!deq.isEmpty()) {
                        sb.append(',').append(deq.pollFirst());
                    }
                }
                // 반대방향인경우
                else {
                    sb.append(deq.pollLast());
                    while (!deq.isEmpty()) {
                        sb.append(',').append(deq.pollLast());
                    }
                }
            }
            sb.append(']').append('\n');
        }

    }


