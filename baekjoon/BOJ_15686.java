package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15686 {
    // x, y 위치 Point 정의
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] arr;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 1인경우 집
                if (arr[i][j] == 1) {
                    person.add(new Point(i, j));
                    // 2인 경우 치킨집
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == M) {
           int res = 0;
        
        for (int i = 0; i < person.size(); i++) {
            int temp = Integer.MAX_VALUE;
            // 오픈한 치킨집 중 하나와 집의 모든 거리를 비교해서 최소 거리를 구함
            for (int j = 0; j < chicken.size(); j++) {
                if (open[j]) {
                    int distance = Math.abs(person.get(i).x - chicken.get(j).x) + Math.abs(person.get(i).y - chicken.get(j).y);
                    temp = Math.min(temp, distance);
                }
            }
            res += temp;
            }
        ans = Math.min(ans, res);
        return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }
}