import java.util.*;

class Solution {
    
    public static int[] nums;
    public static int targetNum;
    public static int cnt;
    
    public static void dfs(int now, int depth) {
        if(depth==nums.length) {
            if(now==targetNum) cnt++;
            return;
        }
        
        dfs(now+nums[depth], depth+1);
        dfs(now-nums[depth], depth+1);
        
        return;
    };
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        targetNum = target;
        cnt = 0;
        dfs(0,0);
        int answer = cnt;
        return answer;
    }
}