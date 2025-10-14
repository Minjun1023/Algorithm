package baekjoon;

import java.io.*;
import java.util.*;

/*
 * NBA 농구
 * 경기: 48분동안 진행
 */
public class BOJ_2852 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int score1 = 0;
        int score2 = 0;
        int lastLeadChangeTime = 0;

        int leadTime1 = 0;
        int leadTime2 = 0;

        int endTime = 60 * 48;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] strTime = st.nextToken().split(":");
            int scoreTime = Integer.parseInt(strTime[0]) * 60 + Integer.parseInt(strTime[1]);

            // 경기 진행 중
            if (score1 > score2) {
                leadTime1 += scoreTime - lastLeadChangeTime;
            } else if (score2 > score1) {
                leadTime2 += scoreTime - lastLeadChangeTime;
            }

            if (team == 1) {
                score1++;
            } else {
                score2++;
            }

            lastLeadChangeTime = scoreTime;
        }

        // 경기 종료 후
        if (score1 > score2) {
            leadTime1 += endTime - lastLeadChangeTime;
        } else if (score2 > score1) {
            leadTime2 += endTime - lastLeadChangeTime;
        }

        int min1 = leadTime1 / 60;
        int sec1 = leadTime1 % 60;
        int min2 = leadTime2 / 60;
        int sec2 = leadTime2 % 60;

        System.out.print(String.format("%02d:%02d\n", min1, sec1));
        System.out.print(String.format("%02d:%02d\n", min2, sec2));

    }
    
}
