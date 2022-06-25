import java.util.*;

public class run_18 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
        int[] check = {0,0,0};
        //각 학생의 찍는 패턴과 학생마다 맞은 개수를 파악하는 check이다.
        int n = 0;

        for(int i=0;i<answers.length;i++){
            if(answers[i] == answer1[i%answer1.length]){
                check[0]++;
            }
            if(answers[i] == answer2[i%answer2.length]){
                check[1]++;
            }
            if(answers[i] == answer3[i%answer3.length]){
                check[2]++;
            }
            //answers에 있는 답지를 가져와 같다면 각 학생들의 정답 개수를 체크한다.
        }
        for(int num : check) set.add(num);
        //각 학생의 정답 개수를 중복없이 넣는다.
        for(int top : check) n = Math.max(n, top);
        //그중 가장 많이 맞은 정답의 개수를 찾는다.

        if(set.size() == 1){
            list.add(1);
            list.add(2);
            list.add(3);
            //만약 정답 개수가 1개라면 모두가 같은 점수를 받았으므로 가장 많이 맞춘 학생 모두를 넣는다.
        }else{
            for(int i=0;i<3;i++){
                if(check[i] == n){
                    list.add(i+1);
                    //아니라면 가장 많이 맞춘 학생을 찾아 list에 한명만 넣는다.
                }
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        run_18 sol = new run_18();
        int [] arr = {2,2,3,4,1};
        System.out.print(Arrays.toString(sol.solution(arr)));
    }
}
