package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2110 {
    static int N, C;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);

        int lo = 1; // 최소 거리
        int hi = map[N-1] - map[0]; // 촤대 거리

        while (lo <= hi) {
            int mid = (lo+hi) / 2;
            // mid 거리로 설치 가능 -> 더 크게 시도
            if (canInstall(mid) >= C) {
                lo = mid + 1;
            }
            else {
                // 설치 불가능 -> 거리 축소
                hi = mid - 1;
            }
        }

        System.out.println(hi);
    }

    public static int canInstall(int distance) {
        int count = 1;
        int lastLocate = map[0];

        for (int i = 1; i < map.length; i++) {
            int locate = map[i];

            /* 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가 최소 거리보다 크거나 같은 경우
            공유기 설치 개수를 늘려주고 마지막 설치 위치를 갱신
            */
            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
    
}