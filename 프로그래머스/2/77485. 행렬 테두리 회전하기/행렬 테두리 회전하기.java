import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] nums = new int[rows][columns];
        int cnt = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                nums[i][j] = cnt++;
            }
        }
        
        int T = queries.length;
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<T; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int temp = nums[x1][y1]; // 좌측 상단 값 빼두기
            int min = temp;

            // 좌측 테두리 (아래에서 위로 채우기)
            for(int k = x1; k < x2; k++) {
                nums[k][y1] = nums[k+1][y1];
                min = Math.min(min, nums[k][y1]);
            }

            // 하단 테두리 (오른쪽에서 왼쪽으로 채우기)
            for(int k = y1; k < y2; k++) {
                nums[x2][k] = nums[x2][k+1];
                min = Math.min(min, nums[x2][k]);
            }

            // 우측 테두리 (위에서 아래로 당기기)
            for(int k = x2; k > x1; k--) {
                nums[k][y2] = nums[k-1][y2];
                min = Math.min(min, nums[k][y2]);
            }

            // 상단 테두리 (왼쪽에서 오른쪽으로 채우기)
            for(int k = y2; k > y1; k--) {
                nums[x1][k] = nums[x1][k-1];
                min = Math.min(min, nums[x1][k]);
            }

            // 처음 빼두었던 값을 원래 가야 할 자리에 넣기
            nums[x1][y1+1] = temp;
            
            answerList.add(min); // 최솟값 정답 배열에 추가
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}