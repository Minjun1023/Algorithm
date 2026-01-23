import java.io.*;
import java.util.*;

public class Main {
    static int x;
    // 가장 큰 값을 출력하기 위해 내림차순으로 정렬
    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        for (int i = 0; i < x; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                q.add(num);
            } else {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
        }
    }
