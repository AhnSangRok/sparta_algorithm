import java.util.*;

public class run_19 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<Character> arr = new ArrayList<>();
        Arrays.sort(strings);
        String delete = "";

        for(int i=0;i<strings.length;i++){
            arr.add(strings[i].charAt(n));
            //각 문자열의 n번째 알파벳을 구한다.
        }
        Collections.sort(arr);
        //알파벳을 정렬한다.

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<strings.length;j++){
                if (strings[j] == delete){
                    continue;
                    //만약 strings의 j번째가 이미 확인 했다면 continue
                }
                if(arr.get(i) == strings[j].charAt(n)){
                    answer[i] = strings[j];
                    strings[j] = delete;
                    break;
                    //정렬된 알파벳을 통해 해당 단어를 찾아 answer에 넣는다.
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        run_19 sol = new run_19();
        String [] strings = {"sun", "bed", "car"};
        System.out.print(Arrays.toString(sol.solution(strings, 2)));
    }
}
