import java.util.*;
public class run_15 {
    public int[] solution(int []arr) { // 같은 수는 싫어

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]){
                list.add(arr[i]);
                //만약 앞에 있는 수가 뒤의 수와 다르다면 앞에 있는 수를 저장 다르다면 저장하지 않는다
            }
            if(i==arr.length-2){
                list.add(arr[arr.length-1]);
                //마지막 수만 남았다면 그대로 저장
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        run_15 sol = new run_15();
        int [] arr = {3,1,1,1,4,5,5,6};
        System.out.print(Arrays.toString(sol.solution(arr)));
    }
}
