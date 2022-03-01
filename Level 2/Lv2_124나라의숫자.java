package programmers;

public class Lv2_124나라의숫자 {
	static String[] rule = {"1", "2", "4"};

	class Solution {    
	    public String solution(int n) {
	        if(n <= 3) return rule[n-1];
	        else {
	            int p = (n-1) / 3;     // 몫
	            int q = (n-1) % 3;     // 나머지
	            
	            return solution(p) + rule[q];
	        }
	    }
	}
}
