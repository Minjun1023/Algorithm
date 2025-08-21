package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_12015 {
    static int a;
    static int[] seq;
    static int cnt;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        a = Integer.parseInt(br.readLine());
        seq = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < a; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            // 10 20 10 30 20 50
        }

        list.add(seq[0]);
        
        for (int i = 1; i < a; i++) {
            int key = seq[i];

            // key값이 list의 마지막 값 보다 클 경우
            if (key > list.get(list.size() - 1)) {
                list.add(key);
            } else {
                int lo = 0;
                int hi = list.size() - 1;

                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (list.get(mid) < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                list.set(lo, key);
            }
        }
        System.out.println(list.size());
    }
}
