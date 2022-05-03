package programmers;

import java.util.LinkedList;
import java.util.List;

public class Lv2_프린터 {
	static class Printer {
        int priority, loc;
        
        Printer(int priority, int loc) {
            this.priority = priority;
            this.loc = loc;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Printer> list = new LinkedList<Printer>();
        
        for(int i=0; i<priorities.length; i++) {
            list.add(new Printer(priorities[i], i));
        }
        
        while(true) {
            Printer printer = list.get(0);
            boolean chk = true;
            for(int i=1; i<list.size(); i++) {
                if(printer.priority < list.get(i).priority) {
                    chk = false;
                    break;
                }
            }
            list.remove(0);         // 앞에서 빼서
            
            if(!chk) {  // 하나라도 큰 우선순위가 존재한다면
                list.add(printer);      // 뒤로 보내기
            } else {
                answer++;   // 인쇄 횟수 1 증가
                if(printer.loc == location) {   // 내가 원하는 문서가 인쇄됬다면
                    break;
                }
            }
        }
        
        return answer;
    }
}
