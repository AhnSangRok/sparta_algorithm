import java.util.*;

public class run_20 {
    public String solution(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        //먼저 str을 정렬해준다.
        return new StringBuilder(new String(str)).reverse().toString();
        //StringBuilder에 있는 reverse를 통해 뒤집어서 return해 줬다.
    }

    public static void main(String[] args) {
        run_20 sol = new run_20();
        System.out.print(sol.solution("dfcwbgAz"));
    }
}
