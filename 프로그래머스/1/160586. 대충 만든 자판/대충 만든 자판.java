import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                
                if (map.containsKey(c)) {
                    map.put(c, Math.min(map.get(c), j+1));
                } else {
                    map.put(c, j+1);
                }
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            
            int sum = 0;
            boolean possible = true;
            
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                
                if (!map.containsKey(c)) {
                    possible = false;
                    break;
                }
                
                sum += map.get(c);
            }
            
            if (!possible) {
                answer[i] = -1;
            } else {
                answer[i] = sum;
            }
        }
        
        return answer;
    }
}