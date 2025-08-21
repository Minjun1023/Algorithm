package codetest.구현;

import java.io.*;
import java.util.*;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열을 여러 번 연결 할 경우 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        // String input = br.readLine();
        String input = sc.nextLine();

        ArrayList<Character> result = new ArrayList<Character>();
        int value = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                result.add(input.charAt(i));
            } else {
                value += input.charAt(i) - '0';
            }
        }

        Collections.sort(result);

        // for (char ch : result) {
        //     sb.append(ch);
        // }

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
        }
        
        if (value != 0) sb.append(value);

        System.out.println(sb);
    }    
}
