package baekjoon;

import java.io.*;
import java.util.*;

/*
 * 모음 (a,e,i,o,u)하나를 반드시 포함
 * 모음이 3개 혹은 자음이 3개 연속으로 오면 안됨
 * 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용
 */
public class BOJ_4659 {
 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            // end 일 경우 종료
            if (input.equals("end")) {
                break;
            }

            char[] arr = input.toCharArray();

            boolean containsVowels = false; // 모음 포함 검사 변수
            boolean threeTimesInARow = false;   // 모음 or 자음 세 번 연속일 경우
            int vowelsInARowCount = 0; // 연속으로 나온 모음 횟수
            int consonantsInARowCount = 0;  // 연속으로 나온 자음 횟수
            boolean doubleInARowCheck = false;  // 같은 글자 연속 두번 체크 변수

            for (int i = 0; i < arr.length; i++) {
                // 모음인 경우
                if (vowelCheck(arr[i])) {
                    containsVowels = true;
                    // 모음 개수 카운트
                    vowelsInARowCount++;
                    // 자음 개수 초기화
                    consonantsInARowCount = 0;
                } else {
                    // 모음이 아닌 경우 자음의 개수 카운트
                    consonantsInARowCount++;
                    // 모음 개수 초기화
                    vowelsInARowCount = 0;
                }
                // 연속으로 나온 모음 개수가 3개 이상이거나 자음의 개수가 3개 이상인 경우
                if (vowelsInARowCount >= 3 || consonantsInARowCount >= 3) {
                    threeTimesInARow = true;
                    break;
                }

                // 3번 조건
                if (i >= 1) {
                    if (arr[i-1] == arr[i]) {
                        // ee인 경우
                        if (arr[i] == 'e') {
                            continue;
                        // oo인 경우
                        } else if (arr[i] == 'o') {
                            continue;
                        }
                        doubleInARowCheck = true;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("<");
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
            }
            sb.append("> is ");
            // 3가지 조건에 만족하지 않은 경우
            if (!containsVowels || threeTimesInARow || doubleInARowCheck) {
                sb.append("not ");
            }
            sb.append("acceptable.");

            System.out.println(sb);
        }
    }
    // 모음 체크 (1번 조건)
    static boolean vowelCheck(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
    
}
