import java.util.*;
public class run_16 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> sum = new ArrayList<>();
        ArrayList<Integer> solution = new ArrayList<>();
        int n = 0;

        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                sum.add(numbers[i] + numbers[j]);
                //일단 배열에 있는 모든 수를 2가지씩 더해서 sum에 넣는다.
            }
        }
        Collections.sort(sum);
        // 더한 수를 오름차순으로 정렬한다.
        for(int number : sum){
            if(!solution.contains(number))
                solution.add(number);
            //만약 중복되었는 수를 제외하고 solution에 넣는다.
        }

        int[] answer = new int[solution.size()];

        for(int i = 0;i<solution.size();i++){
            answer[i] = solution.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        run_16 sol = new run_16();
        int [] arr = {1,2,3,4,2,3};
        System.out.print(Arrays.toString(sol.solution(arr)));
    }
}
