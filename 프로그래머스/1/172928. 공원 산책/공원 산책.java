class Solution {
    public int[] solution(String[] park, String[] routes) {
        int r = park.length;
        int c = park[0].length();
        int startX = 0;
        int startY = 0;
        
        char[][] arr = new char[r][c];
        
        for (int i = 0; i < r; i++) {
           for (int j = 0; j < c; j++) {
               arr[i][j] = park[i].charAt(j);
               if (arr[i][j] == 'S') {
                   startX = i;
                   startY = j;
               }
           }
        }
        
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);
            
            int nx = startX;
            int ny = startY;
            boolean ok = true;
            
            for (int i = 0; i < distance; i++) {
                if (direction.equals("E")) {
                    ny++;
                }
                else if (direction.equals("S")) {
                    nx++;
                }
                else if (direction.equals("W")) {
                    ny--;
                }
                else {
                    nx--;
                }
                
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    ok = false;
                    break;
                }
                
                if (arr[nx][ny] == 'X') {
                    ok = false;
                    break;
                }
            }
            
            if (ok) {
                startX = nx;
                startY = ny;
            }
        }
        
        return new int[] {startX, startY};
        
    }
}