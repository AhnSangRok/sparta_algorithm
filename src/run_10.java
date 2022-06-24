import java.util.*;
public class run_10 {
    public int[] solution(int[] arr) {
        ArrayList <Integer> list = new ArrayList<>();
        int min = arr[0];
        // 가장 작은 수를 임의로 배열의 첫번째로 넣는다.
        int check=0;

        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
            if(min > arr[i]){
                min = arr[i];
                check = i;
                //list에 차례로 넣지만 그중 가장 작은 수의 인덱스를 check안에 넣는다.
            }
        }

        list.remove(check);
        //가장 작은 수를 제거한다.

        if(arr.length > 1){
            int[] answer = new int[arr.length-1];
            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
            return answer;
        }else{
            int[] answer = {-1};
            return answer;
        }
        //만약 배열의 길이가 1보다 작다면 -1을 리턴한다.
    }

    public static void main(String[] args) {
        run_10 sol = new run_10();
        int [] arr = {10};
        System.out.print(Arrays.toString(sol.solution(arr)));
    }
}
