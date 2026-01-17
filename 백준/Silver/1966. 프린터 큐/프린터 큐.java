import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {    
                int num = Integer.parseInt(st.nextToken());

                q.add(new int[] {j, num});
            }

            int cnt = 0;
            while (true) {
                int[] cur = q.poll();
                boolean chk = true;

                for (int[] curQ: q) {
                    if (curQ[1] > cur[1]) {
                        chk = false;
                        break;
                    }
                }

                if (chk) {
                    cnt++;
                    if (cur[0] == m) break;
                } else {
                    q.add(cur);
                }
            }

            System.out.println(cnt);
        }
    }
}
