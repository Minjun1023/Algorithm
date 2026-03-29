import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 노래의 고유 번호
        ArrayList<Integer> answer = new ArrayList<>();
        // 장르 내에서 노래들의 총 재생 횟수 저장
        Map<String, Integer> num = new HashMap<>();
        // 장르 내에서 노래들의 고유 번호와 재생 횟수 저장
        Map<String, Map<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            if (!num.containsKey(genres[i])) {
                // num 해시맵에 해당 장르 정보가 존재하지 않는다면,
                // 새로운 HashMap을 생성하여 노래 고유 번호와 재생 횟수를 저장, music과 num에 해당 정보를 추가
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                // 이미 해당 장르가 num에 존재하는 경우, 해당 장르의 HashMap에 새로운 노래 정보를 추가하고, 총 재생 횟수를 갱신
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList(num.keySet());
        // 가장 많이 재생된 노래를 먼저 수록하기 위해 내림차순으로 정렬
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1)));
        
        for (String key : keySet) {
            Map<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
            
            // 각 장르의 HashMap에서 키셋(노래 고유 번호)을 가져와 재생 횟수에 따라 내림차순으로 정렬
            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));
            
            // 각 장르에서 재생 횟수가 가장 높은 노래 두 개를 answer 리스트에 추가
            answer.add(genre_key.get(0));
            if (genre_key.size() > 1) answer.add(genre_key.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}