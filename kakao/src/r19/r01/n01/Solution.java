package r19.r01.n01;

// https://www.welcomekakao.com/learn/courses/30/lessons/42888?language=java
// 오픈채팅방
// 정확성: 32/32
// 효율성: -
// 정답입니다!

import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
        
        for (String s : solution(record)) {
            System.out.print(s + " ");
        }
        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이
        // 들어왔습니다."]
    }
    
    public static String[] solution(String[] record) {
        StringTokenizer st;
        HashMap<String, String> hm = new HashMap<String, String>();
        int count = 0;
        String[] message;
        
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String action = st.nextToken(), id = st.nextToken(), name = null;
            
            if (st.hasMoreTokens()) {
                name = st.nextToken();
            }
            
            switch (action) {
                case "Enter":
                    hm.put(id, name);
                    count++;
                    break;
                case "Change":
                    hm.replace(id, name);
                    break;
                case "Leave":
                    count++;
                    break;
                default:
                    break;
            }
        }
        
        message = new String[count];
        count = 0;
        
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String action = st.nextToken(), id = st.nextToken();
            
            switch (action) {
                case "Enter":
                    message[count] = hm.get(id) + "님이 들어왔습니다.";
                    count++;
                    break;
                case "Leave":
                    message[count] = hm.get(id) + "님이 나갔습니다.";
                    count++;
                    break;
                default:
                    break;
            }
        }
        
        return message;
    }
}
