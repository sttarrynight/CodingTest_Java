import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        // 시작,끝 인덱스 모두 0에서 출발
        // 누적합 배열에서 끝인덱스 - (시작인덱스-1)와 k와 비교
        // 그 값이 k보다 작으면 끝 인덱스를 +1
        // 그 값이 k보다 크면 시작 인덱스를 +1
        // 값이 k와 같으면 비교 후 길이가 짧은 인덱스 저장 및 시작 인덱스 +1 (탐색을 이어나감)
        
        int[] sums = new int[sequence.length];
        sums[0] = sequence[0];
        
        for(int i=1; i<sums.length; i++) {
            sums[i] = sums[i-1] + sequence[i];
        }
        
        int start = 0;
        int end = 0;
        int[] answer = new int[2];
        answer[1] = 1000001;
        
        while(end < sums.length) {
            int cur = start==0 ? sums[end] : sums[end] - sums[start-1];
            if(cur < k) {
                end++;
            } else if(cur > k) {
                start++;
            } else {
                if(end-start < answer[1]-answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                }
                start++;
            }
        }
        
        return answer;
    }
}