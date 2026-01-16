import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<int[]> deq = new ArrayDeque<>();
        int[] ballonLocation = new int[n];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ballonLocation[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(1 + " ");
        int idx = ballonLocation[0];

        for (int i = 1; i < n; i++) {
            deq.offer(new int[] {i+1, ballonLocation[i]});
        }

        while (!deq.isEmpty()) {
            if (idx > 0) {

                for (int i = 1; i < idx; i++) {
                    deq.offerLast(deq.pollFirst());
                }

                int[] cur = deq.pollFirst();
                sb.append(cur[0]).append(" ");
                idx = cur[1];

            } else {

                for (int i = 1; i < -idx; i++) {
                    deq.addFirst(deq.pollLast());
                }

                int[] cur = deq.pollLast();
                sb.append(cur[0]).append(" "); 
                idx = cur[1];
            }
        }

        System.out.print(sb);
       
    }
    
}
