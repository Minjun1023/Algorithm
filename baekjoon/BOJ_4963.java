package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_4963 {

    static int w, h, nowX, nowY;
    static int[][] map;
    static boolean[][] check;
    static int dirX[] = {0, 0,- 1, 1, -1, 1, -1, 1};
    static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException { 
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = " ";
        // 입력으로 두개의 0이 주어질 경우 종료
        while (!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            check = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        
        int island_cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 방문하지 않고 섬(island)인 경우
                if (!check[i][j] && map[i][j] == 1) {
                    // BFS 호출
                    BFS(i, j);
                    // 섬의 개수 추가
                    island_cnt++;
                }
            }
        }
        sb.append(island_cnt).append('\n');
    }
    System.out.println(sb);
}

static void BFS(int x, int y) {
    Queue<Node> q = new LinkedList<Node>();
    // 방문 처리
    check[x][y] = true;
    q.offer(new Node(x, y));

    while (!q.isEmpty()) {
        Node node = q.poll();

        // 상하좌우, 대각선 방향 정의
        for (int i = 0; i < 8; i++) {
            nowX = dirX[i] + node.x;
            nowY = dirY[i] + node.y;

        // 범위 안에 존재하면서, 현재 위치를 방문하지 않고, 현재 위치가 섬인 경우
        if (range_check() && !check[nowX][nowY] && map[nowX][nowY] == 1) {
            check[nowX][nowY] = true;
            q.offer(new Node(nowX, nowY));
            }
        }
    }
}

// 범위 체크
static boolean range_check() {
    return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
    }
}

