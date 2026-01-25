import java.io.*;
import java.util.*;

public class Main {
    
    public static void clean(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        while (!pq.isEmpty()) {
            int x = pq.peek();
            if (map.getOrDefault(x, 0) == 0) {
                pq.poll();
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
    
        while (t --> 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    minPQ.add(num);
                    maxPQ.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {    
                    if (map.isEmpty()) continue;

                    if (num == 1) {
                        clean(maxPQ, map);
                        if (!maxPQ.isEmpty()) {
                            int x = maxPQ.poll();
                            map.put(x, map.get(x) - 1);
                            if (map.get(x) == 0) map.remove(x);
                        }
                    } else {
                        clean(minPQ, map);
                        if (!minPQ.isEmpty()) {
                            int x = minPQ.poll();
                            map.put(x, map.get(x) - 1);
                            if (map.get(x) == 0) map.remove(x);
                        }
                    }
                }     
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                clean(maxPQ, map);
                clean(minPQ, map);
                sb.append(maxPQ.peek()).append(" ").append(minPQ.peek()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
