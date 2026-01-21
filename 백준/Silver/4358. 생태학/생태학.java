import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> m = new HashMap<>();
    static int size = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String str = br.readLine();

            if (str == null || str.length() == 0) break;
            
            size++;
            m.put(str, m.getOrDefault(str, 0) + 1);
        }

        solve();
        System.out.print(sb);
    }

    public static void solve() {
        Object[] keys = m.keySet().toArray();
        Arrays.sort(keys);

        for (int i = 0; i < keys.length; i++) {
            String key = (String) keys[i];
            int treeSize = m.get(key);
            double result = (double) (100 * treeSize) / size;
            sb.append(key + " " + String.format("%.4f", result)).append('\n');
        }
    }
}
