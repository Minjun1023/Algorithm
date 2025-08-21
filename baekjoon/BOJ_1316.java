package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ_1316 {

     static boolean checkStr(String str) {

        // 알파벳 개수 26개
        boolean[] checkAlpha = new boolean[26];
        // 이전
        int prev = -1;

        for (int i = 0; i < str.length(); i++) {
            // 현재 알파벳의 값(int)
            int now = str.charAt(i);

            // 이전과 현재가 다르다면
            if(prev != now) {
                // 문자가 처음 나왔을 경우
                if(checkAlpha[now-97] == false) {
                    checkAlpha[now-97] = true;
                    prev = now;
                    // 아닐 경우 
                } else {
                    return false;
                }
                // 이전과 현재가 다르지 않을 경우
            } else {
                continue;
            }
        }
        return true;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(checkStr(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
