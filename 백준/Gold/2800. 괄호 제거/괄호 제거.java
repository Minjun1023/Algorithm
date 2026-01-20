import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> brackets;
    static Set<String> result;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        brackets = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                s.push(i);
            } else if (c == ')') {
                // 괄호쌍
                brackets.add(new int[] {s.pop(), i});
            }
        }

        check = new boolean[str.length()];
        result = new TreeSet<>();
        comb(0, str.toCharArray());

        for (String v : result) {
            System.out.println(v);
        }
    }

    static void comb(int depth, char[] str) {
        if (depth == brackets.size()) {
            // 괄호를 지웠는지의 여부
            boolean f = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (!check[i]) {
                    sb.append(str[i]);
                } else f = true;
            }
            // 괄호를 지웠을 경우
            if (f) {
                result.add(sb.toString());
            }
            return;
        }

        comb(depth+1, str);

        int[] bracket = brackets.get(depth);
        // [3,5]
        check[bracket[0]] = true;
        check[bracket[1]] = true;
        comb(depth+1, str);
        // [0,6]
        check[bracket[0]] = false;
        check[bracket[1]] = false;

    }
}
