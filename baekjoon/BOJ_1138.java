package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1138 {
    public static final int blank = -1;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        // arr 배열을 -1로 초기화
        Arrays.fill(arr, blank);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tall = 0; tall < n; tall++) {
            int leftCount = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                // 비어있을경우
                if (arr[i] == blank) {
                    if (cnt == leftCount) {
                        arr[i] = tall + 1;
                        break;
                    }
                    cnt++;
                }
            }                                                                                                                                                                                                                                                                                       
        }
        // 출력
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
