package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10709 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] board = new int[h][w];

        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                if (input.charAt(j) == 'c') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 0) {
                    for (int k = j+1; k < w; k++) {
                        if (board[i][k] != 0) {
                            board[i][k] = board[i][k-1] + 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
