package i19.r01.n01;

// https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
// 크레인 인형뽑기 게임
// 정확성: 11/11
// 효율성: -
// 정답입니다!

public class Solution {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 },
                { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        
        System.out.println(solution(board, moves));
        // 4
    }
    
    public static int solution(int[][] board, int[] moves) {
        int[] basket = new int[moves.length];
        int index = 0, count = 0;
        
        for (int i = 0; i < moves.length; i++) {
            int column = moves[i] - 1;
            
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][column] != 0) {
                    basket[index] = board[j][column];
                    board[j][column] = 0;
                    
                    if (index > 0 && basket[index] == basket[index - 1]) {
                        count += 2;
                        index -= 1;
                    } else {
                        index++;
                    }
                    
                    break;
                }
            }
        }
        
        return count;
    }
}
