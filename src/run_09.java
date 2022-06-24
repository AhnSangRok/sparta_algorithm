import java.util.*;
public class run_09 {
    public long solution(long n) {
        long answer = 0;
        long number = (long)Math.sqrt(n);
        // sqrt()를 사용해 가장 가까운 제곱 수를 구한다.
        if(Math.pow(number,2) == n ){
            //pow()를 사용하해 다시 제곱 수를 제곱해 처음 넣은 값과 같은지 확인한다.
            answer = (long)Math.pow(number+1,2);
            //같다면 제곱 수에 1을 더해 제곱한다.
        }else{
            answer = -1;
            //아니라면 -1을 출력한다.
        }
        return answer;
    }

    public static void main(String[] args) {
        run_09 sol = new run_09();
        System.out.print(sol.solution(122));
    }
}
