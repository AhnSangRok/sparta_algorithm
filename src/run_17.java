import java.util.Arrays;

public class run_17 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 1};
        int check = 0;
        int count = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                lottos[i] = win_nums[i];
                //lottos에 0이 있으면 수를 변경할 수 있기때문에 일단 당첨되는 수를 넣고 그 빈도수 만큼 count에 넣는다.
                count++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    check++;
                    break;
                    //lottos와 win_nums에 같은 수가 있다면 check를 통해 측정하고 빠져나간다. 빠져나가는 이유는 로또는 중복되는 수가 없기때문
                }
            }
        }

        switch (check) {
            //check를 통해 맞은 수를 파악할 수 있다.
            case 0:
            case 1:
                answer[0] = 6;
                answer[1] = 6;
                break;
                //동일한 수가 없거나 1개만 있기 때문에 6등을 리턴한다.
            case 2:
                if (count >= 0) {
                    answer[0] = 5;
                    answer[1] = 5 + count;
                }
                break;
            case 3:
                if (count >= 0) {
                    answer[0] = 4;
                    answer[1] = 4 + count;
                }
                break;
            case 4:
                if (count >= 0) {
                    answer[0] = 3;
                    answer[1] = 3 + count;
                }
                break;
            case 5:
                if (count >= 0) {
                    answer[0] = 2;
                    answer[1] = 2 + count;
                }
                break;
            case 6:
                if (count >= 0 && count < 6) {
                    answer[0] = 1;
                    answer[1] = 1 + count;
                } else if (count == 6) {
                    answer[0] = 1;
                    answer[1] = count;
                }
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        run_17 sol = new run_17();
        int [] lotto = {44, 1, 0, 0, 31, 25};
        int [] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.print(Arrays.toString(sol.solution(lotto,win_nums)));
    }
}
