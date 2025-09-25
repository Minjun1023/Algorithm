package baekjoon;

import java.io.*;
import java.util.*;
/*
 * 자주 나오는 단어일수록 앞에 배치
 * 해당 단어의 길이가 길수록 앞에 배치
 * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
 * 입력받은 문자의 길이 M 이상
 * swift - 3 빈도순
 * mouse - 2 빈도순
 * 길이순, 사전순
 * appearance - 1 
 * attendance - 1
 * append - 1
 * wallet - 1
 */

public class BOJ_20920 {
   
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override 
            public int compare(String o1, String o2) {
                // 자주 등장하는 순서대로 단어 배치
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                // 등장 횟수가 같을 경우, 단어의 길이 순으로 단어 배치
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 등장 횟수와 길이가 같을 경우, 알파벳 사전 순으로 단어 배치
                return o1.compareTo(o2);
            }
        });

        // StringBuilder로 시간초과 발생 X, System.out.println()으로 반복 출력시 시간 초과 발생
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}
