import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> dq = new LinkedList<>();

        while (n --> 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals( "push")) {
                dq.offer(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop")) {
                if (!dq.isEmpty()) {
                    sb.append(dq.poll()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if (str.equals("size")) {
                sb.append(dq.size()).append('\n');
            } else if (str.equals("empty")) {
                if (!dq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(1).append('\n');
                }
            } else if (str.equals("front")) {
                 if (!dq.isEmpty()) {
                    sb.append(dq.peekFirst()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else {
                 if (!dq.isEmpty()) {
                    sb.append(dq.peekLast()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }
        }
        System.out.print(sb);

    }
    
}
