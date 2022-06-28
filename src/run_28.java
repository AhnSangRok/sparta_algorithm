import java.util.Arrays;

public class run_28 {
    public String solution(int n, int m) { //int[]로 선언했더니 주소값이 나와서 String으로 변경했다.
        int[] answer = new int[2];
        int i = 0;

        while(true){
            i++;
            if(n%i == 0 && m%i == 0){
                //최대공약수를 구한다.
                answer[0] = i;
            }
            if(n <= i || m <= i){
                //최소공배수를 구한다.
                answer[1] = n*m/answer[0];
                break;
            }
        }
        return Arrays.toString(answer);
    }

    public static void main(String[] args) {
        run_28 sol = new run_28();
        System.out.print(sol.solution(15,25));
    }
}
