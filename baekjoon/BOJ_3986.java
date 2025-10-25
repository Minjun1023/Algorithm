package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3986 {
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if ((!stack.isEmpty()) && c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }

            stack.clear();
        }
        sb.append(cnt).append("\n");
        System.out.print(sb);

    }

}
