package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16953 {
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int ans = 1;
        while (b != a) {
            // a가 더 클 경우
            if (b < a) {
                ans = -1;
                break;
            }
        // 문자열로 변환
        String str = String.valueOf(b);
        
        // 2로 나누어 떨어지는경우
        if (b % 2 == 0) {
            b /= 2;
        } // 끝자리가 1인경우
        else if (str.charAt(str.length() - 1) == '1') {
            str = str.substring(0, str.length() - 1);
            // 숫자형으로 변환
            b = Integer.parseInt(str);
        } else {
            ans = -1;
            break;
        }
        ans++;
    }
    System.out.println(ans);
    }
}
