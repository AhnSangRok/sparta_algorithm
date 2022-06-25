import java.util.*;

public class run_13 {
    public int solution(int n) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        int answer = 0;
        int mok = 0;
        int nam = 0;
        int z = 1;

        while (true) {
            if (n < 3) {
                num.add(n);
                break;
            }
            mok = n / 3;
            nam = n % 3;
            num.add(nam);
            n = mok;
            //일단 n을 3진수로 바꿔서 num에 저장한다.
        }
        for (int i = num.size() - 1; i >= 0; i--) {
            int count = num.get(i);
            count *= z;
            answer += count;
            z *= 3;
            //저장된 진수의 순서를 반대로 출력해 10진수로 변환한다.
        }

        return answer;
    }

    public static void main(String[] args) {
        run_13 sol = new run_13();
        System.out.print(sol.solution(9));
    }
}

