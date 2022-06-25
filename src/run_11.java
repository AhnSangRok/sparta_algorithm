public class run_11 {
    public int solution(long num) {
        int answer = 0;

        if(num != 1){
            while(num != 1){
                if(num%2 == 0){
                    answer++;
                    num /= 2;
                    //입력된 수가 짝수라면 2로 나눈다. 그리고 answer에 횟수를 추가한다
                }else{
                    answer++;
                    num = num*3+1;
                    //입력된 수가 홀수라면 3을 곱하고 1을 더한다. 그리고 횟수를 추가한다.
                }
                if(answer > 500){
                    return answer = -1;
                    //만약 횟수가 500이 넘어간다면 -1을 리턴한다.
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        run_11 sol = new run_11();
        System.out.print(sol.solution(25));
    }
}
