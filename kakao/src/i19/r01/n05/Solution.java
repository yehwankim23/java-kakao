package i19.r01.n05;

// https://programmers.co.kr/learn/courses/30/lessons/64062?language=java
// 징검다리 건너기
// 정확성: 23/25
// 효율성: 0/0
// 틀렸습니다!

public class Solution {
    public static void main(String[] args) {
        int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
        int k = 3;
        
        System.out.println(solution(stones, k));
        // 3
    }
    
    public static int solution(int[] stones, int k) {
        int count = 0;
        boolean canCross;
        
        while (count >= 0) {
            for (int i = 0; i < stones.length - k; i++) {
                canCross = false;
                
                for (int j = 0; i + j < stones.length && j < k; j++) {
                    if (stones[i + j] > 0) {
                        canCross = true;
                    }
                }
                
                if (!canCross) {
                    return count;
                }
            }
            
            for (int i = 0; i < stones.length; i++) {
                stones[i]--;
            }
            
            count++;
        }
        
        return count;
    }
}
