import java.util.*;
public class run_22 {
    public int solution(String s) { //이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        //숫자 기호와 영단어를 같은 수 끼리 같은 인덱스를 같게 배열을 선언한다

        for(int i=0;i<10;i++){
            s= s.replace(num[i],digits[i]);
            // s에 포함되어 있는 영단어를 찾아 digits로 변환한다.
        }

        return Integer.parseInt(s); // string함수인 s를 int로 변환해서 return한다
    }

    public static void main(String[] args) {
        run_22 sol = new run_22();
        String str = "one5seven71five7seven";
        System.out.print(sol.solution(str));
    }
}
