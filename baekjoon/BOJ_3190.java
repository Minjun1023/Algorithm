package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3190{

    static class spin {
        int time;
        String dir;

        spin (int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Node {
        int row;
        int col;

        Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            // 사과의 위치
            map[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        Queue<spin> spin = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            spin.offer(new spin(time, dir));
        }
        // 북 동 남 서 (시계방향)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int row = 1;
        int col = 1;
        int time = 0;
        // 오른쪽 = 1
        int dir = 1;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        map[row][col] = 2;

        while (true) {
            int dR = row + dx[dir];
            int dC = col + dy[dir];

            time++;

            if (dR < 1 || dC < 1 || dR > N || dC > N) break;

            if (map[dR][dC] == 2) break;

            if (map[dR][dC] == 0) {
                Node node = q.poll();
                map[node.row][node.col] = 0;
            }
            // time이 spin에 남아있는 시간에 해당하는 경우
            if (!spin.isEmpty()) {
                if (time == spin.peek().time) {
                    spin s = spin.poll();

                    // 반시계 방향
                    if (s.dir.equals("L")) {
                        dir = (dir+3) % 4;
                        // 시계 방향
                    } else if (s.dir.equals("D")) {
                        dir = (dir+1) % 4;
                    }
                }
            }
            // 현재 위치 표시
            map[dR][dC] = 2;
            // 큐에 추가
            q.offer(new Node(dR, dC));
            // 현재 위치 
            row = dR;
            col = dC;
        }
        // 시간 출력
        System.out.println(time);
    }
}
