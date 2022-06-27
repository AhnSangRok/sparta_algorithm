import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class ch02_spring_homework_bus {

    public String bus(int max_passenger, int now_passenger, int cost, String bus_number, int fuel, int speed, String condition) {
        Random random = new Random();
        Scanner scn = new Scanner(System.in);
        int count = 0;
        String str = "운행을 종료합니다.";

        System.out.println("현재 정보");
        System.out.printf("최대 승객 : %d | 현재 승객 : %d | 비용 : %d | 버스번호 : %s | 연료 : %d | 현재 속도 : %d | 운행상태 : %s\n", max_passenger, now_passenger, cost, bus_number, fuel, speed, condition);

        while(true){
            int use_fuel = random.nextInt(10)+1;
            int ride_passenger = random.nextInt(10);
            int quit_passenger = random.nextInt(now_passenger);

            count++; //운행 횟수
            System.out.printf("%d번째 운행\n", count);

            //출발하기전 연료 체크

            if (fuel - use_fuel<=0){
                System.out.printf("%d만큼 연료를 사용했다.",fuel);
                fuel = 0;
            }else{
                fuel -= use_fuel;
                System.out.printf("%d만큼 연료를 사용했다.\n",use_fuel);
            }
            if (fuel < 10 && fuel > 0){
                System.out.printf("현재 연료가 %d 남았습니다. 주유하는 것을 권장합니다.\n",fuel);
                System.out.println("주유하시겠습니까? y|n");
                String check = scn.next();
                if (check.equals("y")){
                    System.out.println("주유할 양을 정해주세요.");
                    int refuel = scn.nextInt();
                    fuel += refuel;
                    System.out.printf("주유한 양 : %d | 현재 주유량 : %d | 운행을 계속합니다.\n",refuel,fuel);
                }else {
                    System.out.println("운행을 계속합니다.");
                }
            }else if (fuel < 0) {
                System.out.println("현재 연료가 없습니다. 운행을 종료하고 차고지로 이동합니다.");
                fuel = 0;
                now_passenger = 0;
                condition = "차고지행";
                break;
            }

            //이번 정류장에서 승객 승차, 하차
            now_passenger -= quit_passenger;
            now_passenger += ride_passenger;
            if (now_passenger > max_passenger){
                int miss_passenger = now_passenger - max_passenger;
                System.out.printf("%d명의 승객이 타려했으나 현재 만석이라 %d명의 승객은 탑승하지 못했다.\n",ride_passenger,miss_passenger);
            }else{
                System.out.printf("%d명의 승객이 탑승, %d명의 승객이 하차했습니다. 현재 %d개의 좌석이 남았다.\n",ride_passenger,quit_passenger,max_passenger-now_passenger);
            }

            //출발! 속도 변경
            System.out.printf("이제 출발 합니다. 변속할 속도를 말씀해주세요.\n",speed);
            int shift = scn.nextInt();
            if ((speed + shift) <= 0){
                System.out.println("이런 기어를 넣지 않았습니다. 변속할 속도를 말씀해주세요.");
                shift = scn.nextInt();
                speed += shift;
                if ((speed + shift) <= 0){
                    System.out.println("현재 버스에 문제가 생겼습니다. 운행을 종료하고 차고지로 이동합니다.");
                    now_passenger = 0;
                    condition = "차고지행";
                    speed = 0;
                    break;
                }
            }else{
                speed += shift;
                System.out.printf("다음 목적지로 출발합니다. 현재 속도는 %d km 입니다.\n",speed);
            }
            System.out.printf("%d 번째 운행 정보\r",count);
            System.out.printf("최대 승객 : %d | 현재 승객 : %d | 비용 : %d | 버스번호 : %s | 연료 : %d | 현재 속도 : %d | 운행상태 : %s \n", max_passenger, now_passenger, cost, bus_number, fuel, speed, condition);
            System.out.println("계속 운행하시겠습니까? y|n");
            String yorn = scn.next();
            if (yorn.equals("n")){
                System.out.println("==========================================================================================================================================");
                break;
            }
            System.out.println("==========================================================================================================================================");
        }
        System.out.printf("최대 승객 : %d | 현재 승객 : %d | 비용 : %d | 버스번호 : %s | 연료 : %d | 현재 속도 : %d | 운행상태 : %s | 운행횟수 : %d\n", max_passenger, now_passenger, cost, bus_number, fuel, speed, condition,count);

        return str;
    }

    public static void main(String[] args) {
        ch02_spring_homework_bus sol = new ch02_spring_homework_bus();
        Scanner scn = new Scanner(System.in);

        System.out.print("최대 승객수 : ");
        int max_passenger = scn.nextInt();
        System.out.print("\r");

        System.out.print("현재 승객수 : ");
        int now_passenger = scn.nextInt();
        System.out.print("\r");

        System.out.print("비용 : ");
        int cost = scn.nextInt();
        System.out.print("\r");

        String bus_number = UUID.randomUUID().toString(); // UUID로 고유한 번호 생성
        bus_number = bus_number.replace("[-_.]","");
        bus_number = bus_number.substring(0,4);
        System.out.printf("버스 번호 : %s \n", bus_number);

        System.out.print("현재 연료 : ");
        int fuel = scn.nextInt();
        System.out.print("\r");

        System.out.print("현재 속도 : ");
        int speed = scn.nextInt();
        System.out.print("\r");

        String condition = "운행중";
        System.out.printf("현재 상태 : %s",condition);
        System.out.print("\r");

        System.out.println("========================================================================================");
        System.out.println(sol.bus(max_passenger, now_passenger, cost, bus_number, fuel, speed, condition));
    }
}
