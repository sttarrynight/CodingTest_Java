import java.util.*;

class Solution {
    
    public int gcd(int a, int b) {
        int A, B;
        if(a > b) {
            A = a; B = b;
        } else {
            A = b; B = a;
        }
        while(B!=0) {
            int r = A % B;
            A = B;
            B = r;
        }
        return A;
    }
    
    public int checkMaxDiv(int[] arr, int gcd) {
        for(int n : arr) {
            if(n % gcd ==0) return 0;
        }
        return gcd;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) {
            gcdA = gcd(arrayA[i],gcdA);
            gcdB = gcd(arrayB[i],gcdB);
        }
        
        int answer = Math.max(checkMaxDiv(arrayA,gcdB), checkMaxDiv(arrayB,gcdA));
        
        return answer;
    }
}