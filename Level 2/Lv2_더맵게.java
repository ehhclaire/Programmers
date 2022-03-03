package programmers;

import java.util.PriorityQueue;

public class Lv2_더맵게 {
	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;     // 섞은 횟수
	        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	        
	        for(int s : scoville) {
	            queue.add(s);
	        }
	        
	        while(true) {
	            int a = queue.poll();   // 첫번째 숫자 꺼내기
	            
	            // 모든 음식의 스코빌 지수가 K 이상인 경우
	            if(a >= K) break;
	            
	            // 더이상 꺼낼 숫자가 없을 경우
	            if(queue.isEmpty() && a < K) {
	                answer = -1;
	                break;
	            }
	            
	            int b = queue.poll();   // 두번째 숫자 꺼내기
	            queue.add(a + b*2);     // 새로은 조합의 스코빌 지수 추가
	            answer++;   // 횟수 증가
	        }
	        
	        return answer;
	    }
	}
}
