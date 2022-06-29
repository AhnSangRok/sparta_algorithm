import java.util.*;
public class run_38 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<moves.length;i++){
            int k = 0; // 크래인이 내려가는 깊이 y축 담당
            int check = moves[i]-1; //index // 크래인 위치 x축 담당
            while(true){
                if(board[k][check]>0){ // x축에 인형이 있다면 가져오기
                    list.add(board[k][check]);
                    board[k][check] = 0;
                    break;
                }
                if(board.length-2 < k){ // 끝까지 내려가도 없다면 while문 빠져나오기
                    break;
                }else{
                    k++;
                }
            }
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) == list.get(i+1)){ //연속해서 같은 인형이 있다면 지우기
                list.remove(i);
                list.remove(i);
                answer+=2;
                i = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        run_38 sol =new run_38();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.print(sol.solution(board,moves));
    }
}
