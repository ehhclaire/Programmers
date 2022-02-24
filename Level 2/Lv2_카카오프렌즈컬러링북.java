package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_카카오프렌즈컬러링북 {
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;

	class Solution {
	    
	    public int[] solution(int m, int n, int[][] picture) {
	        int numberOfArea = 0;
	        int maxSizeOfOneArea = 0;
	        
	        visited = new boolean[m][n];
	        
	        for(int r=0; r<m; r++) {
	            for(int c=0; c<n; c++){
	                if(!visited[r][c] && picture[r][c]>0) {
	                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(r, c, picture));  // 한 영역내 칸의 수 max 값으로 갱신
	                    numberOfArea++;     // 총 영역의 수 1 증가
	                }
	            }
	        }

	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	    
	    public int bfs(int i, int j, int[][] picture) {
	        Queue<int[]> queue = new LinkedList<int[]>();
	        queue.offer(new int[]{i, j});
	        visited[i][j] = true;
	        int cnt = 1;    // 영역 내 칸의 개수 count
	        
	        while(!queue.isEmpty()) {
	            int[] curr = queue.poll();
	            int r = curr[0];
	            int c = curr[1];
	            // 사방 탐색
	            for(int d=0; d<4; d++){
	                int nr = r + delta[d][0];
	                int nc = c + delta[d][1];
	                if(nr>-1 && nr<picture.length && nc>-1 && nc<picture[0].length  // 영역 내에 존재하면서
	                  && !visited[nr][nc]   // 아직 방문하지 않았으면서
	                  && picture[r][c] == picture[nr][nc]) {  // 이웃좌표가 현재좌표 값과 같다면              
	                    queue.offer(new int[]{nr, nc});
	                    visited[nr][nc] = true;
	                    cnt++;
	                }
	            }
	        }
	        return cnt;
	    }
	}
}
