import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Set<String> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s2 = br.readLine();   
            if (s.contains(s2)) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
