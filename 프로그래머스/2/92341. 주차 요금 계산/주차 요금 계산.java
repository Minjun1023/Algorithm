import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new TreeMap<>();
        Map<String, Integer> totalFee = new TreeMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" ");
            // 시각
            int time = getTime(temp[0]);
            // 차량 번호
            String car = temp[1];
            // 내역
            String his = temp[2];
            
            // 입차
            if (his.equals("IN")) {
                parking.put(car, time);
            // 출차
            } else {
                // 처음 출차하는 경우
                if (!totalFee.containsKey(car)) {
                    totalFee.put(car, time - parking.get(car));
                // 출차한적이 있는 경우
                } else {
                    totalFee.put(car, totalFee.get(car) + time - parking.get(car));
                }
                // 시간 계산한 경우 기록 삭제
                parking.remove(car);
            }
        }
        
        // 입차된 이후에 출차된 내역이 없는 경우
        if (!parking.isEmpty()) {
            for (String car : parking.keySet()) {
                Integer fee = totalFee.get(car);
                fee = (fee == null) ? 0 : fee;
                // 23:59분에 출차된 것으로 간주하여 계산
                totalFee.put(car, fee + (23 * 60 + 59) - parking.get(car));
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer t : totalFee.values()) {
            int baseTime = fees[0];
            int baseFee = fees[1];
            int partTime = fees[2];
            int partFee = fees[3];
            
            // 기본 시간보다 작은 경우
            if (t <= baseTime) {
                list.add(baseFee);
            // 기본 시간보다 큰 경우
            } else {
                list.add((int) (baseFee + Math.ceil((double) (t - baseTime) / partTime) * partFee));
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
        
    }
    
    public Integer getTime(String s) {
        String[] temp = s.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}