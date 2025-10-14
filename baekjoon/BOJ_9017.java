package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9017 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스
        int t = Integer.parseInt(br.readLine());
        int[] answer = new int[t];
        

        for (int i = 0; i < t; i++) {
            // 정수
            int n = Integer.parseInt(br.readLine());

            int[] ranks = new int[n];
            Map<Integer, Integer> cntMap = new HashMap<>();  // 팀별 인원수 측정
            int teamNum = Integer.MIN_VALUE;    // 가장 큰 번호의 팀

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                // 데이터 
                int x = Integer.parseInt(st.nextToken());

                cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
                ranks[j] = x;
                teamNum = Math.max(teamNum, x); // 가장 큰 번호의 팀을 구해서 fifth 배열 값 생성
            }

            // 5번째 선수 저장 배열
            int[] fifth = new int[teamNum + 1];
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> tmpMap = new HashMap<>(); // 팀별 누적합 점수 계산
            int score = 1;

            for (int r : ranks) {
                // 팀 인원수가 6명인경우
                if (cntMap.get(r) == 6) {
                    tmpMap.put(r, tmpMap.getOrDefault(r, 0) + 1);   
                    // 해당 팀의 4명까지만 점수 측정
                    if (tmpMap.get(r) <= 4) {
                        scoreMap.put(r, scoreMap.getOrDefault(r, 0) + score);
                    }
                    // 해당 팀의 5번째 선수의 점수
                    if (tmpMap.get(r) == 5) {
                        fifth[r] = score;
                    }
                    score++;
                }
            }

            int result = Integer.MAX_VALUE; // 가장 낮은 점수
            int fifthScore = Integer.MAX_VALUE; // 5번째 점수

            for (Integer key : scoreMap.keySet()) {
                int tmp = scoreMap.get(key);

                if (tmp < result) { // 점수가 가장 낮은 팀이 우승
                    result = tmp;
                    fifthScore = fifth[key];
                    answer[i] = key;
                }
                else if (tmp == result) {   // 점수가 동점일 경우, 5번째 선수의 점수가 낮을 때 우승
                    if (fifthScore > fifth[key]) {
                        answer[i] = key;
                    }
                }
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }

    }
    
}
