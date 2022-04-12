package programmers;

import java.util.LinkedList;
import java.util.List;

public class Lv2_수식최대화 {
	static char perm[];
    static char[] operator_arr = {'+', '-', '*'};
    static boolean visited[];
    static List<Character> operator;
    static List<Long> operand;
    static long answer;
    
    public long solution(String expression) {
        answer = Long.MIN_VALUE;
        operator = new LinkedList<Character>(); // 연산자
        operand = new LinkedList<Long>();    // 피연산자
        
        String op = "";
        for(int i=0; i<expression.length(); i++) {
            if(isOperator(expression.charAt(i))) {
                operator.add(expression.charAt(i));
                operand.add(Long.parseLong(op));
                op = "";
            } else {
                op += expression.charAt(i);
            }
        }
        operand.add(Long.parseLong(op));
        
        perm = new char[3];
        visited = new boolean[3];
        permutation(0);
        
        return answer;
    }
    
     // 연산자 우선순위 구하기
    static public void permutation(int cnt) {
        if(cnt == 3) {
            check();
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(visited[i]) continue;
            
            perm[cnt] = operator_arr[i];
            visited[i] = true;
            permutation(cnt+1);
            visited[i] = false;
        }   
    }
    
    // 현재 연산자 우선순위로 받을 수 있는 상금 구하기
    static public void check() {
        // 0 : +, 1 : -, 2 : *
        List<Character> oper = new LinkedList<Character>(); // 연산자
        List<Long> num = new LinkedList<Long>();  // 피연산자
        
        // 연산자 복사
        for(int i=0; i<operator.size(); i++) {
            oper.add(operator.get(i));
        }
        // 피연산자 복사
        for(int i=0; i<operand.size(); i++) {
            num.add(operand.get(i));
        }
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<oper.size(); j++) {
                if(oper.get(j) == perm[i]) {
                    long result = 0;
                    if(perm[i] == '+') {
                        result = num.get(j) + num.get(j+1);
                        
                    } else if(perm[i] == '-') {
                        result = num.get(j) - num.get(j+1);
                        
                    } else {
                        result = num.get(j) * num.get(j+1);
                        
                    }
                    num.set(j, result);
                    num.remove(j+1);
                    oper.remove(j);
                    j-=1;
                }
            } 
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    
    // 현재 문자가 연산자인지 판별
    static public boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '*') return true;
        return false;
    }
}
