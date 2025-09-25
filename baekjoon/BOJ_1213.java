package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1213 {
   
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alpha = new int[26];
        // 입력받은 알파벳의 개수 저장
        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'A';
            alpha[idx]++;
        }

        // 입력받은 알파벳의 개수가 홀수인 알파벳인 경우 isOne++
        int isOne = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) isOne++;
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 홀수인 알파벳의 개수가 2개이상인 경우 
        if (isOne > 1) answer += "I'm Sorry Hansoo";
        // 0개 이거나 짝수개인 경우
        else {
            // 맨 앞에는 알파벳의 개수 / 2
            for (int i = 0; i < alpha.length; i++) {
                for (int r = 0; r < alpha[i] / 2; r++) {
                        sb.append((char)(i+65));
                }
            }
            answer += sb.toString();
            // 끝에는 맨 앞에 것을 거꾸로
            String end = sb.reverse().toString();

            sb = new StringBuilder();
            // 가운데에는 알파벳의 개수 홀수개인 경우
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 == 1) {
                    sb.append((char)(i+65));
                }
            }
            answer += sb.toString() + end;
        }
        System.out.println(answer);
    }
}
