public class run_21 {
    public int solution(int[] nums) { //배열에 있는 수 3개의 합이 소수인 경우의 수 찾기
        int answer = 0;
        int check = 0;
        int sum = 0;

        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    //배열의 첫번째를 기준으로 3개의 합을 구하는 경우의 수를 모두 더 할수 있도록 했다.
                    sum = nums[i] + nums[j] + nums[k];
                    for(int x=2;x<=sum/2;x++){
                        if(sum % x == 0){
                            check++;
                        }
                        //3개의 합이 소수인지 파악한다.
                    }
                    if(check == 0){
                        answer++;
                    }
                    //만약 소수라면 경우의 개수를 1 추가한다.
                    sum = 0;
                    check = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        run_21 sol = new run_21();
        int [] arr = {1,2,3,4,7,5};
        System.out.print(sol.solution(arr));
    }
}
