package baekjoon;

import java.io.*;
import java.util.*;

// 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 갯수 구하기
// 회의는 한번 시작하면 중간에 중단 X, 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있음
// 회의의 시작 시간과 끝나는 시간이 같을 수도 있다. -> 시작하자마자 끝난다.

public class BOJ_1931{
    static int n;
    static int[][] time;
    static int cnt;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            time = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                time[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
                time[i][1] = Integer.parseInt(st.nextToken());  // 끝나는 시간
            }

            Arrays.sort(time, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    // 종료 시간이 같은 경우
                    if (o1[1] == o2[1]) {
                        // 시작 시간이 빠른 순으로 정렬
                        return o1[0] - o2[0];
                    }
                    // 종료 시간이 다른 경우 종료 시간이 빠른 순으로 정렬
                    return o1[1] - o2[1];
                }
            });
            
            cnt = 0;
            int prev_end_time = 0;

            for (int i = 0; i < n; i++) {
                // 직전 종료 시간이 다음 회의 시작시간보다 작거나 같을 경우
                if (prev_end_time <= time[i][0]) {
                    // 직전 종료 시간을 다음 회의 종료 시간으로 갱신
                    prev_end_time = time[i][1];
                    cnt++;
                }
            }

            System.out.println(cnt);

        }
    }