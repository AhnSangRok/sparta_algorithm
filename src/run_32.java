import java.util.*;
public class run_32 {
    class Fail{
        int stage;
        double rate;
        Fail(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }

    Comparator<Fail> comp = new Comparator<Fail>(){
        public int compare(Fail a, Fail b){
            if(a.rate < b.rate){
                return 1;
            }else if(a.rate > b.rate){
                return -1;
            }else{
                if(a.stage > b.stage){
                    return 1;
                }else if(a.stage < b.stage){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    };

    public String solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Fail> fails = new ArrayList<Fail>();
        int total = stages.length;

        int[] users = new int[N+1];
        for(int s : stages){
            users[s-1]++;
        }

        for(int i=0;i<N;i++){
            if(users[i] == 0){
                fails.add(new Fail(i+1, 0));
            }else{
                fails.add(new Fail(i+1, (double)users[i]/total));
                total -= users[i];
            }
        }

        Collections.sort(fails, comp);
        for(int i=0; i<N; i++){
            answer[i] = fails.get(i).stage;
        }

        return Arrays.toString(answer);
    }

    public static void main(String[] args) {
        run_32 sol = new run_32();
        int []stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.print(sol.solution(5,stages));
    }
}
