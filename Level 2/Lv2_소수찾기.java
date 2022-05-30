package programmers;

import java.util.HashSet;
import java.util.Set;

public class Lv2_소수찾기 {
	static char perm[];
    static boolean visited[];
    static Set<Integer> set = new HashSet<Integer>();
    
    public int solution(String numbers) {        
        for(int i=1; i<=numbers.length(); i++) {
            perm = new char[i];
            visited = new boolean[numbers.length()];
            permutation(0, i, numbers);
        }
        
        return set.size();
    }
    
    static private void permutation(int cnt, int N, String numbers) {
        if(cnt == N) {
            if(perm[0] != '0') {
                int num = Integer.parseInt(String.valueOf(perm));
                if(!set.contains(num)) {
                     boolean isPrime = check(num);
                    if(isPrime) set.add(num);
                }
            }
            return;
        }
        
        
        for(int i=0; i<numbers.length(); i++) {
            if(visited[i]) continue;
            
            perm[cnt] = numbers.charAt(i);
            visited[i] = true;
            permutation(cnt+1, N, numbers);
            visited[i] = false;
        }
    }
    
    static private boolean check(int num) {
        if(num < 2) return false;
        
        if(num == 2) return true;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
