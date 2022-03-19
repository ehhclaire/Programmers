package programmers;

public class Lv2_행렬테두리회전하기 {
	static int[][] board;   // 행렬
	static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}}; // 4방 탐색 (우 -> 하 -> 좌 -> 상)

	class Solution {
	    public int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        board = new int[rows][columns];
	        
	        // 초기화
	        int number = 1;
	        for(int r=0; r<rows; r++) {
	            for(int c=0; c<columns; c++) {
	                board[r][c] = number++;
	            }
	        }
	        
	        // 회전시키기
	        for(int i=0; i<queries.length; i++) {
	            answer[i] = turn(queries[i], 0, rows, columns);
	        }
	        
	        return answer;
	    }
	    
	    public int turn(int[] q, int direction, int rows, int columns) {
	        int min = Integer.MAX_VALUE;
	        int r = q[0]-1;
	        int c = q[1]-1;
	        
	        int current = board[r][c];  // 현재좌표
	        int next = 0;               // 다음 좌표
	        while(true) {
	        	min = Math.min(min, board[r][c]);   // 영역 내 최소값을 갱신
	
	            // 현재 방향에서 다음 좌표
	        	int nr = r + delta[direction][0];
	            int nc = c + delta[direction][1];
	            
	            // 영역 밖이거나 모서리 지점이라면, 방향 전환
	            if(nr<q[0]-1 || nr>q[2]-1 || nc<q[1]-1 || nc>q[3]-1) {
	                direction++;
	                if(direction==4) break;         // 시계방향으로 전부 돌았다면 while문 탈출
	                
	                // 방향 전환 후, 새로운 위치의 다음 좌표
	                nr = r + delta[direction][0];   
	                nc = c + delta[direction][1];
	            }
	            
	            next = board[nr][nc];	// 다음 값 저장
	            board[nr][nc] = current;    // 다음 좌표에 현재 값 저장
	            current = next;         // 다음 반복을 위해 현재 값을 다음 값으로 갱신
	
	            // 전진한 좌표를 현좌표로 갱신
	            r = nr; 
	            c = nc;
	        }
	        return min;     // 현재 영역의 최소값 return
	    }
	}
}