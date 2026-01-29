import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            // 중앙 이전 값
            PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
            // 중앙 이후 값
            PriorityQueue<Integer> minH = new PriorityQueue<>();

            int m = Integer.parseInt(br.readLine());

            // 중앙값의 개수
            sb.append((m / 2) + 1).append('\n');

            // 띄어쓰기 개수
            int cnt = 0;
            
            for (int i = 0; i < m; i++) {
                // 한 줄에 10개 출력
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                // maxH minH의 사이즈 오차는 최대 1
                if (maxH.size() == minH.size()) {
                    maxH.offer(x);  
                } else {
                    minH.offer(x);  
                }

                if (!minH.isEmpty()) {
                    if (maxH.peek() > minH.peek()) {
                        int t1 = maxH.poll();
                        int t2 = minH.poll();

                        maxH.offer(t2);
                        minH.offer(t1);
                        
                    }
                }

                // 중앙값 출력
                if (i % 2 == 0) {
                    if (cnt == 9 || i == m-1) {
                        sb.append(maxH.peek() + "\n");
                        cnt = 0;
                    } else {
                        sb.append(maxH.peek() + " ");
                    }
                    cnt++;
                }
            }
        }
        System.out.print(sb);
    }
}