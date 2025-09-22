package baekjoon;

import java.io.*;
import java.util.*;

/*
 *  ABCDE
    abcde
    01234
    FGHIJ
    fghij

    Aa0FfBb1GgCc2HhDd3IiEe4Jj
 */
public class BOJ_10798 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] ch = new char[5][15];
        int max = 0;
        for (int i = 0; i < ch.length; i++) {
            String input = br.readLine();
            if (max < input.length()) {
                max = input.length();
            }
            for (int j = 0; j < input.length(); j++) {
                ch[i][j] = input.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                // 공백일 경우 제외
                if (ch[j][i] == '\0') continue;
                sb.append(ch[j][i]);
            }
        }
        System.out.println(sb);
    }
}
