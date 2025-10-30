package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2910 {
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();    // 값 저장
        HashMap<Integer, Integer> order = new HashMap<>();  // 입력 순서
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!order.containsKey(num)) order.put(num, i); // 입력 순서 저장
            map.put(num, map.getOrDefault(num, 0) + 1); // 값 카운팅
        }

        List<Integer> lst = new ArrayList<>(map.keySet());
        Collections.sort(lst, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 값이 같을 경우 인덱스가 작은 순서로 출력
                if (map.get(o1).equals(map.get(o2))) {
                    return order.get(o1) - order.get(o2);
                }
                // 아닐 경우 빈도수가 많은 순서대로 출력
                return map.get(o2) - map.get(o1);
            }
        });
        
        for (int key : lst) {
            for (int i = 0; i < map.get(key); i++) {
                System.out.print(key + " ");
            }
        }
    }
    
}
