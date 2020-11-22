package i19.r01.n04;

// https://programmers.co.kr/learn/courses/30/lessons/64063?language=java
// 호텔 방 배정
// 정확성: 26/26
// 효율성: 2/7
// 틀렸습니다!

public class Solution {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = { 1, 3, 4, 1, 3, 1 };
        
        for (int i = 0; i < room_number.length; i++) {
            System.out.print(solution(k, room_number)[i] + " ");
        }
        // [1,3,4,2,5,6]
    }
    
    public static long[] solution(long k, long[] room_number) {
        // need to handle k > Integer.MAX_VALUE
        int[] room = new int[(int) k];
        long[] assignment = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++) {
            for (int j = (int) room_number[i] - 1; j < k; j++) {
                if (room[j] == 0) {
                    room[j] = 1;
                    assignment[i] = j + 1;
                    
                    break;
                }
            }
        }
        
        return assignment;
    }
}
