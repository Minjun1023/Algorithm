package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       Set<Integer> set = new HashSet<>();
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
       }
       List<Integer> lst = new ArrayList<>(set);
       Collections.sort(lst);

       StringBuilder sb = new StringBuilder();
       for (int i : lst) {
            sb.append(i).append(" ");
       }
       System.out.println(sb.toString());
    }
}


