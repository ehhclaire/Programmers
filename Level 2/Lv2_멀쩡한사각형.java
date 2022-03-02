package programmers;

public class Lv2_멀쩡한사각형 {
	public long solution(long w, long h) {
        long GCD = 0;

        // w, h의 최대공약수 구하기
        long max = Math.min(w, h);
        for(int i=1; i<=max; i++) {
            if(w % i == 0 && h % i ==0) GCD = i;
        }
        
        return w * h - (w + h - GCD);
    }
}
