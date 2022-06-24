import java.util.*;
public class run_05 {
    public String solution(String s) {
        String[] answer = s.split("");
        //answer에 s에 있는 문자열을 알파벳 하나씩 잘라 배열에 넣는다.
        int index = 0;
        //쪼갠 단어의 알파벳의 순번을 알기위해 순번을 넣을 index를 만들었다.
        for (int i = 0; i < answer.length; i++){
            if (answer[i].equals(" ")){
                index = 0;
                //answer의 공백을 만날경우 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야하므로 단어의 순번을 다시 0으로 초기화한다.
            }
            else{
                if (index % 2 == 0){
                    answer[i] = answer[i].toUpperCase();
                    //첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 하므로 toUpperCase()를 이용해 대문자로 만든다.
                }else{
                    answer[i] = answer[i].toLowerCase();
                    // 홀수 번째는 소문자로 만들어야 하므로 toLowerCase()를 사용했다.
                }
                index++;
            }
        }
        return String.join("", answer);
        // 다시 String으로 만들기 위해 Join을 한다.
    }

    public static void main(String[] args) {
        run_05 sol = new run_05();
        System.out.print(sol.solution("try hello world"));
    }
}
