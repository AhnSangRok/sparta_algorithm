import java.util.*;

public class run_27 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        //지원 받은 금액을 최대한 많은 부서에게 전해야한다. 그러므로 가장 적은 부서부터 주기위해 오름차순으로 정렬했다.

        for(int i=0;i<d.length;i++){
            if(budget - d[i]>=0){
                //지원금액이 다 동나기전까지 순번대로 지원금을 나눠준다.
                budget -= d[i];
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        run_27 sol = new run_27();
        int [] d = {5,1,2,7,9};
        System.out.print(sol.solution(d,10));
    }
}
