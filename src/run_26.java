public class run_26 {
    public int solution(int n) {
        int answer = 0;

        if(n > 0){
            for(int i=1;i<=n;i++){
                if(n%i == 0){
                    answer = answer+i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        run_26 sol = new run_26();
        System.out.print(sol.solution(12));
    }
}
