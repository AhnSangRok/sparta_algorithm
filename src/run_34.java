import java.util.*;
public class run_34 {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]); // 각 종류의 포켓몬을 HashSet에 넣어서 중복을 제거한다.
        }

        if(set.size()<=nums.length/2){ // 종류가 가져갈 수 있는양 보다 적을 경우 종류의 개수 만큼을 더한다.
            answer = set.size();
        }else{
            answer = nums.length/2; // 종류가 가져갈 수 있는 최대 개수보다 많을 경우 가져갈 수 있는 최대 값을 넘겨준다.
        }

        return answer;
    }

    public static void main(String[] args) {
        run_34 sol = new run_34();
        int[] nums = {3,3,2,2,2,2};
        System.out.print(sol.solution(nums));
    }
}
