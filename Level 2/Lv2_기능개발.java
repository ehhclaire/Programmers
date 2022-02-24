package programmers;

import java.util.ArrayList;
import java.util.List;

public class Lv2_기능개발 {
	class Solution {
	    public List<Integer> solution(int[] progresses, int[] speeds) {
	        int size = progresses.length;
	        int[] days = new int[size];
	        List<Integer> answer = new ArrayList<Integer>();        
	        
	        for(int i=0; i<size; i++) {
	            int left = 100 - progresses[i];
	            
	            // 해당 작업 배포가능한 날 계산
	            int day = left / speeds[i];
	            if(left % speeds[i] > 0) day++;
	            
	            days[i] = day;
	            
	        }
	        
	        int num = 1;
	        int max = days[0];
	        for(int i=1; i<size; i++) {
	            if(max < days[i]) {
	                answer.add(num);    // 현재 같이 배포할 수 있는 작업 수 answer에 추가
	                
	                // 초기화
	                max = days[i];
	                num = 1;
	            } else {
	                num++;  // 함께 배포할 수 있는 작업 수 증가
	            }
	        }
	        answer.add(num);    // 남은 배포 작업 처리
	        
	        return answer;
	    }
	}
}
