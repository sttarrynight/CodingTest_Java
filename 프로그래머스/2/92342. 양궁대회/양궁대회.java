import java.util.*;

class Solution {
    
    public static int[] arr; // dfs 함수 인자로 넣어줄 계속 변화하는 배열
    public static int[] maxArr; // 최종 답으로 제출할 가장 점수차이가 큰 조합 담는 배열
    public static int[] apeachArr; // 어피치 점수 배열(=info)
    public static int scoreDiff; // 가장 큰 점수 차이를 담는 변수
    
    public static int isWin(int[] arr) {
        int apeach = 0;
        int lion = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0 && apeachArr[i]==0) continue;
            if(arr[i] > apeachArr[i]) {
                lion += 10-i;
            } else {
                apeach += 10-i;
            }
        }
        return lion - apeach;
    }
    
    public static void dfs(int idx, int[] arrNow, int n) {
        if(idx==11) {
            arrNow[10] = n;
            n=0;
        }
        if(n==0) {
            int diff = isWin(arrNow);
            if(diff>=scoreDiff) {
                if(diff==scoreDiff){
                    boolean isChange = false;
                    for(int j=10; j>=0; j--) {
                        if(arrNow[j]==maxArr[j]) continue;
                        else if(arrNow[j]>maxArr[j]) {
                            isChange = true; break;
                        }
                        else break;
                    }
                    if(isChange) {
                        for(int i=0; i<arrNow.length; i++){
                        maxArr[i] = arrNow[i];
                    }
                    scoreDiff = diff;
                    }
                } else {
                    for(int i=0; i<arrNow.length; i++){
                        maxArr[i] = arrNow[i];
                    }
                    scoreDiff = diff;
                }
            }
            return;
        }
        
        for(int i=n; i>=0; i--) {
            arrNow[idx] = i;
            dfs(idx+1, arrNow, n-i);
            arrNow[idx] = 0;
        }
        
        return;
    }
    
    public int[] solution(int n, int[] info) {
        arr = new int[11];
        maxArr = new int[11];
        apeachArr = info;
        scoreDiff = 0;
        dfs(0,arr,n);
        int[] answer = scoreDiff<=0 ? new int[] {-1} : maxArr;
        return answer;
    }
}