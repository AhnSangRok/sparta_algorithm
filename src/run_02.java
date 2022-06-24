import java.util.*;
class run_02 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor == 0){
                list.add(arr[i]);
            }
        }
        // arr에서 divisor의 수로 나눠떨어지는 수만 list에 자장 되도록 한다.

        if(list.size() == 0){
            list.add(-1);
        }
        // 만약 list의 size를 측정해 값이 0, 즉 저장된 값이 하나라도 없다면 -1이 저장 되도록 했다.

        Collections.sort(list);
        // sort로 list를 오름차순으로 정렬했다.

        int answer[] = new int[list.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,6,20,50};
        run_02 sol = new run_02();
        System.out.print(Arrays.toString(sol.solution(arr, 5)));
    }
}
