import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1); 
                } else {
                    if (map.isEmpty()) continue;
                    
                    if (num == 1) {
                        int max = map.lastKey();
                        if (map.put(max, map.get(max) - 1) == 1) {
                            map.remove(max);
                        }
                    } else {
                        int min = map.firstKey();
                        if (map.put(min, map.get(min) - 1) == 1) {
                            map.remove(min);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
            }
        }
        System.out.print(sb);
    }
    
}
