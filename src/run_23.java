public class run_23 {
    public String solution(String s, int n) { //어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
        String answer = "";
        char[] arr = s.toCharArray();
        //받은 String을 배열 형태로 전환한다.

        for(int i=0;i<arr.length;i++){
            if(arr[i] == ' '){
                answer += " ";
                // 빈칸은 그대로 answer에 넣는다.
            }else if(arr[i]+n > 'z' && arr[i] <= 'z'){
                answer += Character.toString(arr[i]+n+'a'-'z'-1);
                // z에서 1만큼 움직이면 a가 되므로 만약 arr[i]+n이 z를 넘을 경우 그만큼 z를 빼고 a와 넘어갈때 1만큼의 움직임 빼준다.
            }else if(arr[i]+n > 'Z' && arr[i] <= 'Z'){
                answer += Character.toString(arr[i]+n+'A'-'Z'-1);
                //소문자와 동일하게 설정한다.
            }else{
                answer += Character.toString(arr[i]+n);
                //만약 z나 Z를 넘지 않는 경우 그대로 더한 값을 answer에 넣는다.
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        run_23 sol = new run_23();
        String s = "ABzsd";
        int n = 13;
        System.out.print(sol.solution(s, n));
    }
}
