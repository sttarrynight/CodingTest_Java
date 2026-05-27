import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> genreTotalPlayedMap = new HashMap<>();
        Map<String,PriorityQueue<int[]>> genreMusicMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            genreTotalPlayedMap.put(genres[i],genreTotalPlayedMap.getOrDefault(genres[i],0) + plays[i]);
            if(genreMusicMap.containsKey(genres[i])) {
                genreMusicMap.get(genres[i]).add(new int[] {i,plays[i]});
            } else {
                PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->{
                    if(p1[1]==p2[1]) {
        	            return p1[0] - p2[0];
                    } else {
        	            return p2[1] - p1[1];
                    }
                });
                pq.add(new int[] {i,plays[i]});
                genreMusicMap.put(genres[i],pq);
            }
        }
        
        Map<Integer,String> genreTotalPlayedRankMap = new TreeMap<>((m1,m2)->{
            return m2-m1;
        });
        
        for(String key : genreTotalPlayedMap.keySet()) {
            genreTotalPlayedRankMap.put(genreTotalPlayedMap.get(key),key);
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for(Integer playedNum : genreTotalPlayedRankMap.keySet()) {
            String gen = genreTotalPlayedRankMap.get(playedNum);
            int cnt = 2;
            while(cnt > 0 && genreMusicMap.get(gen).size() > 0) {
                int[] cur = genreMusicMap.get(gen).poll();
                answerList.add(cur[0]);
                cnt--;
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}