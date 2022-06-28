public class run_30 {
    public int solution(int n) {
        int answer = 0;

        for(int i=2;i<n;i++){
            if((n-1)%i == 0){
                //나머지가 1이 될 수 있는 가장 큰수는 그 수에서 1을 뺀 수, 그 수를 나눌 수 있는 가장 작은 수를 찾으면 된다
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        run_30 sol = new run_30();
        System.out.print(sol.solution(138));
    }
}
