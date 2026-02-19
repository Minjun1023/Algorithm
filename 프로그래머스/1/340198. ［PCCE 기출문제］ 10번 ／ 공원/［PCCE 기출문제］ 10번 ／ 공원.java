import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        int n = park.length;
        int m = park[0].length;
        
        for (int idx = mats.length-1; idx >= 0; idx--) {
            int size = mats[idx];
            
            for (int i = 0; i <= n-size; i++) {
                for (int j = 0; j <= m-size; j++) {
                    if (canPlace(i, j, size, park)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean canPlace(int r, int c, int size, String[][] park) {
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}