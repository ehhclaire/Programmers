package programmers;

public class Lv2_단체사진찍기 {
	static char[] perm;
	static boolean[] Selected;
	static char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int answer;

	class Solution {
	    public int solution(int n, String[] data) {
	        answer = 0;
	        
	        perm = new char[8];
	        Selected = new boolean[8];
	        
	        permutation(0, data);
	        
	        return answer;
	    }
	}
	
	// 순열로 모든 경우 구하기
	public static void permutation(int cnt, String[] data) {
		if(cnt==8) {
			// 하나의 경우가 만들어지는 경우, 사진 촬영 조건을 만족하는지 체크
			check(data);    
			return; 
		}
		
		for(int i=0; i<8; i++) {
			if(Selected[i]) continue;
			
			perm[cnt] = characters[i];
			Selected[i] = true;
			permutation(cnt+1, data);
			Selected[i] = false;
		}
	}
	
	// 사진 촬영 조건을 만족하는지 체크
	public static void check(String[] data) {
		int cnt = 0;    // 만족하는 조건 수 
		
		for(int i=0; i<data.length; i++){
			char f1 = data[i].charAt(0);    // 첫번째 프렌즈
			char f2 = data[i].charAt(2);    // 두번재 프렌즈
			int idx1 = 0, idx2 = 0;
			
			for(int j=0; j<8; j++){
				if(perm[j] == f1) idx1 = j;
				if(perm[j] == f2) idx2 = j;
			}
			
			char operator = data[i].charAt(3);  // 연산자
			
			// 조건을 만족하지 않는 경우 함수 탈출
			if((operator == '=' && Math.abs(idx1-idx2)-1!=(data[i].charAt(4)-'0'))
					|| (operator == '<' && Math.abs(idx1-idx2)-1>=(data[i].charAt(4)-'0'))
					|| (operator == '>' && Math.abs(idx1-idx2)-1<=(data[i].charAt(4)-'0'))){
				return;
			}
		}
		
		// 여기까지 왔다는 말은 위의 모든 data 조건을 만족했다는 뜻임으로 answer 1 증가
		answer++;   
	}
}
