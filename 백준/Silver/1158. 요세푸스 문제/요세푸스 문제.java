import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        sb.append("<");
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        while (!dq.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                dq.offerLast(dq.pollFirst());
            }
            sb.append(dq.pollFirst());

            if (!dq.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.print(sb);
    }
    
}
