import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Map<Integer, String> hm = new HashMap<>();
        Map<String, Integer> hm2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();

            hm.put(i, name);
            hm2.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            
            // 입력받은게 숫자인경우
            if (Character.isDigit(s.charAt(0))) {
                int key = Integer.parseInt(s);
                sb.append(hm.get(key));
            // 입력받은게 문자인경우
            } else {
                sb.append(hm2.get(s));
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }
}
