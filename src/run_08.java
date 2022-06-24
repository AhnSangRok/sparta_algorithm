import java.util.*;
public class run_08 {
    public long solution(long n) {
        ArrayList<Long> list = new ArrayList<>();
        long answer = 0;
        long mul = 1;

        while(n!=0){
            list.add(n%10);
            n /= 10;
            //n에 있는 수를 list 형태로 하나씩 넣는다.
        }

        Collections.sort(list);
        //정렬을 한다.

        for(int i=0;i<list.size();i++){
            answer = answer+list.get(i)*mul;
            mul *= 10;
            //다시 정렬된 list에 있는 수를 차례대로 10의 배수로 곱해 넣는다.
        }

        return answer;
    }

    public static void main(String[] args) {
        run_08 sol = new run_08();
        System.out.print(sol.solution(118372));
    }
}
