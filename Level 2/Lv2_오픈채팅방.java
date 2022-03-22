package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2_오픈채팅방 {
	class Solution {
	    public List<String> solution(String[] record) {
	        List<String> answer = new ArrayList<String>();
	        Map<String, String> map = new HashMap<String, String>();
	        
	        for(int i=0; i<record.length; i++) {
	            String[] curr = record[i].split(" ");   // 입력 문자열 split
	                        
	            // 현재 아이디 값이 존재하지 않거나 닉네임을 변경하는 경우
	            if(curr[0].equals("Enter") || curr[0].equals("Change")) {      
	                map.put(curr[1], curr[2]);      
	            }
	        }
	        
	        // 출력하기
	        for(int i=0; i<record.length; i++) {
	            String[] curr = record[i].split(" ");   // 입력 문자열 split
	            String state = "";

	            if(curr[0].equals("Enter")){
	                state = "님이 들어왔습니다.";    
	            } else if(curr[0].equals("Leave")) {
	                state = "님이 나갔습니다.";
	            } else 
	                continue;
	            answer.add(map.get(curr[1]) + state);
	        }
	        
	        return answer;
	    }
	}
}
