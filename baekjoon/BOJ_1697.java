package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1697 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // N == K이면 0출력
        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean visited[] = new boolean[100001];
        visited[N] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int size = q.size();
        int cnt = 0;
        while (true) {
            // 한 번 진행할때마다 cnt++ 측정
            cnt++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.remove();
                visited[x] = true;
                // 값을 찾은 경우 cnt 출력
                if (x-1 == K || x+1 == K || x*2 == K) {
                    System.out.println(cnt);
                    return;
                }
                // x-1이 0보다 크고 같거나, 방문하지 않은 경우
                if (x-1 >= 0 && !visited[x-1]) {
                    visited[x-1] = true;
                    q.add(x-1);
                }
                // x+1이 100000보다 작고 같거나, 방문하지 않은 경우
                if (x+1 <= 100000 && !visited[x+1]) {
                    visited[x+1] = true;
                    q.add(x+1);
                }
                // x*2이 100000보다 작고 같거나, 방문하지 않은 경우
                if (x*2 <= 100000 && !visited[x*2]) {
                    visited[x*2] = true;
                    q.add(x*2);
                }
            } 
        }
    }
}


