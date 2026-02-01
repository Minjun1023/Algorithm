class Solution {
    
    public boolean[] visited;
    public int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String cur, String target, String[] words, int cnt) {
        // 현재 값이 타겟이면
        if (cur.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            // 이미 방문했을 경우
            if (visited[i]) continue;
            
            // 변환 가능한 경우
            if (canConvert(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean canConvert(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            // 알파벳 일치할 경우 카운트
            if (from.charAt(i) == to.charAt(i)) {
                cnt++;
            }
        }
        // 알파벳 2개 이상 일치할 경우 참
        return from.length() == cnt + 1 ? true : false;
    }
}