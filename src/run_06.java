import java.util.*;
public class run_06 {
    public int solution(int n) {
        int answer = 0;

        while(n!=0){
            answer = answer+ n%10;
            n /= 10;
        }
        //각 자릿수를 구하기 위해 10의 나머지를 모두 합한다.
        return answer;
    }

    public static void main(String[] args) {
        run_06 sol = new run_06();
        System.out.print(sol.solution(123));
    }
}
