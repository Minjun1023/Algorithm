import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            
            if (canConvert(begin, str)) {
                visited[i] = true;
                q.add(i);
                break;
            }
        }
        
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (size --> 0) {
                String cur = words[q.poll()];
                
                if (cur.equals(target)) {
                    return cnt;   
                }
                
                for (int i = 0; i < words.length; i++) {
                    if (visited[i] == true) continue;
                    
                    String str = words[i];
                    
                    if (canConvert(cur, str)) {
                        visited[i] = true;
                        q.add(i);
                    }               
                }
            }
            cnt++;
        }
        return 0;
    }
    
    public boolean canConvert (String from, String to) {
        int cnt = 0;
        
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) == to.charAt(i)) cnt++;
        }
        
        if (from.length() == cnt + 1) {
            return true;
        } else {
            return false;
        }
    }
}