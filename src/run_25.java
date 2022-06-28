public class run_25 {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++){
            int count=1;
            //자기 자신을 미리 포함했다.
            for(int j=1;j<=i/2;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count%2 == 0){
                answer += i;
                //약수의 개수가 짝수인 수를 더한다.
            }else{
                answer -= i;
                //홀수인 경우에는 빼준다.
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        run_25 sol = new run_25();
        System.out.print(sol.solution(12,17));
    }
}
