import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        
        for (int i = 0; i < 4; i++) {
            int nh = h + dx[i];
            int nw = w + dy[i];
            
            if (nh < 0 || nh >= r || nw < 0 || nw >= c) continue;
            
            if (board[h][w].equals(board[nh][nw])) answer++;
        }
        return answer;
    }
}