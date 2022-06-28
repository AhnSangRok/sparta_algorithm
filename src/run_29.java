import java.util.Arrays;
public class run_29 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            //인덱스는 0부터 시작이므로 시작인덱스는 -1을 해준다.
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
            //찾기위한 함수
        }

        return answer;
    }

    public static void main(String[] args) {
        run_29 sol = new run_29();
        int [] array = {1,5,2,6,3,7,4};
        int [][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.print(Arrays.toString(sol.solution(array, commands)));
    }
}

