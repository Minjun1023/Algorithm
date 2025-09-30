package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20291 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map =  new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            sb.append(s + " " + map.get(s) + "\n");
        }
        System.out.println(sb);


    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int N = Integer.parseInt(br.readLine());

    //     Map<String, Integer> map = new HashMap<>();
    //     List<String> list = new ArrayList<>();
        
    //     for (int i = 0; i < N; i++) {
    //         StringTokenizer st = new StringTokenizer(br.readLine(), ".");
    //         st.nextToken();
    //         String extension = st.nextToken();
    //         if (!map.containsKey(extension)) list.add(extension);
    //         map.put(extension, map.getOrDefault(extension, 0) + 1);
    //     }
    //     Collections.sort(list);
    //     StringBuilder sb = new StringBuilder();
    //     for (String s : list) {
    //         sb.append(s + " " + map.get(s) +  "\n");
    //     }
    //     System.out.println(sb);
    // 
    }
}
