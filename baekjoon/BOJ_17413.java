package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17413 { 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean check = false;

        for (int i = 0; i < s.length(); i++) {
            // < 시작전에 있는 문자열들 거꾸로 출력, < 자체는 그대로 출력
            if (s.charAt(i) == '<') {
                check = true;
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            }
            // > 를 만나게 되는 경우 이전까n지의 문자열들 그대로 출력
            else if (s.charAt(i) == '>') {
                check = false;
                sb.append(s.charAt(i));
            }
            // 태그 안에 있는 경우 그대로 출력
            else if (check) {
                sb.append(s.charAt(i));
            }
            // 태그 바깥에 있는 경우
            else if (!check) {
                // 스페이스를 만난 경우
                if (s.charAt(i) == ' ') {
                    // 지금까지 스택에 쌓아두었던 글자들 거꾸로 출력
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    // 스페이스는 그대로 출력
                    sb.append(s.charAt(i));
            }

            // 일반 문자인경우
            else {
                stack.push(s.charAt(i));
            }
        }
    }
    
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
        
    }
}
