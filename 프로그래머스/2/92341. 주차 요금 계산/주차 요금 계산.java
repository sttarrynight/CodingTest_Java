import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer,Integer> carTotalMins = new TreeMap<>();
        HashMap<Integer,String> carIn = new HashMap<>();
        
        for(String rec : records){
            String[] str = rec.split(" ");
            int carNum = Integer.parseInt(str[1]);
            
            if(str[2].equals("IN")){
                carIn.put(carNum,str[0]);
                continue;
            }
            
            String[] carInTime = carIn.get(carNum).split(":");
            int carInMinutes = (Integer.parseInt(carInTime[0])*60) + Integer.parseInt(carInTime[1]);
            String[] carOutTime = str[0].split(":");
            int carOutMinutes = (Integer.parseInt(carOutTime[0])*60) + Integer.parseInt(carOutTime[1]);
            int carMinutes = carOutMinutes - carInMinutes;
            
            carTotalMins.put(carNum, carTotalMins.getOrDefault(carNum,0)+carMinutes);
            carIn.remove(carNum);
        }
        
        for(int carNum : carIn.keySet()){
            String[] carInTime = carIn.get(carNum).split(":");
            int carInMinutes = (Integer.parseInt(carInTime[0])*60) + Integer.parseInt(carInTime[1]);
            int carOutMinutes = 1439;
            int carMinutes = carOutMinutes - carInMinutes;
            
            carTotalMins.put(carNum,carTotalMins.getOrDefault(carNum,0) + carMinutes);
        }
        
        int[] answer = new int[carTotalMins.keySet().size()];
        int i = 0;
        for(int carNum : carTotalMins.keySet()){
            if(carTotalMins.get(carNum)<=fees[0]){
                answer[i++] = fees[1];
            } else {
                answer[i++] = fees[1] + (int) Math.ceil((double)(carTotalMins.get(carNum)-fees[0])/fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}