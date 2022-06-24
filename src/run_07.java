import java.util.*;
public class run_07 {
    public int[] solution(long n) {
        ArrayList<Long> list = new ArrayList<>();

        while(n!=0){
            list.add(n%10);
            n /= 10;
            //자연수 n을 뒤집어 각 자리 숫자를 원소로 넣기위해 10으로 나눈 나머지를 차례대로 넣었다.
        }

        int[] answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).intValue();
            //.intValue()를 사용한 이유는 list안에 들어있는 값들은 long타입이기 때문에 int로 변환하기 위함이다.
        }

        return answer;
    }

    public static void main(String[] args) {
        run_07 sol = new run_07();
        System.out.print(Arrays.toString(sol.solution(566787899)));
    }
}
