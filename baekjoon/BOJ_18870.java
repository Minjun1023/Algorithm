package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_18870 {
    static int N;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] origin;
    static int[] sorted;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        N = Integer.parseInt(br.readLine());
        // 원래 배열
        origin = new int[N];
        // 정렬된 배열
        sorted = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        // 인덱스값
        int rank = 0;
        for (int i = 0; i < N; i++) {
            // map에 정렬된 배열 값이 키에 포함되어 있지 않은 경우
            if (!map.containsKey(sorted[i])) {
                // map에 키를 넣고 값을 증가
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 값 출력
        for (int i = 0; i < N; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
