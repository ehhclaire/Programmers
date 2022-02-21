package programmers;

import java.util.Stack;

public class Lv2_문자열압축 {
	class Solution {
	    public int solution(String s) {
	        int answer = Integer.MAX_VALUE;
	        int len = 1;    // 1부터 입력 문자열 길이까지 1씩 증가
	        
	        // 입력 문자열 길이까지 반복
	        while(len <= s.length()) {
	            String str = s;     // 입력 s 문자열 복제
	            Stack<String> stack = new Stack<String>();
	            for(int i=0; i<s.length(); i+=len) {    // 현재 길이만큼 
	                // 남은 문자열 길이가 자를 길이보다 적으면 그냥 끝까지 자르기
	                if(i+len > s.length()) stack.push(str.substring(i, s.length()));    
	                else stack.push(str.substring(i, i+len));   // 문자열 잘라서 stack에 넣기
	            }
	                        
	            String compare_str = stack.pop();   // 초기 문자열을 꺼내오기
	            int cnt = 0;        // 같은게 몇개있는지 count
	            int length = 0;     // 현재 압축 길이
	            
	            while(!stack.isEmpty()) {
	                String popped_str = stack.pop();    // 다음 문자열 pop으로 꺼내오기
	                if(compare_str.equals(popped_str)) cnt++;
	                else {
	                    if(cnt > 0) length += compare_str.length() + Integer.toString(cnt+1).length();
	                    else length += compare_str.length();
	                    
	                    cnt = 0;
	                    compare_str = popped_str;       // 비교할 문자열 교체
	                }
	            }
	            
	            // 마지막 남은 값 처리
	            if(cnt > 0) length += compare_str.length() + Integer.toString(cnt+1).length();
	            else length += compare_str.length();
	            
	            answer = Math.min(answer, length);      // 혀재 압축한 문자열 길이와 answer 중 최소값으로 answer 갱신

	            len++;  // 자르는 길이 1 증가
	        }
	        
	        return answer;
	    }
	}
}
