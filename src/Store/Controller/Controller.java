package Store.Controller;

import Store.DTO.Dto;
import Store.Service.Service;

import java.util.Scanner;

/*
성빈님  아래 요구사항을  MVC 패턴으로 구성하여 제출해 주세요
총각네 과일가게에서는 사과,딸기,복숭아,배,키위 5가지 과일을 판매합니다.
사장님은 과일의 가격과, 재고(수량)을 쉽게 파악하고 관리하고 싶습니다. 이를 위해 새로운 과일을 추가하거나,
판매하지 않는 과일을 삭제하고 과일의 가격을 수정할 수 있고, 수정된 내용을 볼 수 있는  기능을 사용하고 싶습니다.
이를 통해, 사장->메뉴(Controller) -> 과일 (Service) -> 과일 CRUD (DAO) -> 테이블  구조를 만들어 주세요
 */
public class Controller {
    Scanner scan = new Scanner(System.in);
    Service service = new Service();
    Dto dto;
    public void mainMenu() {
        System.out.println("1. 과일 추가");
        System.out.println("2. 과일 삭제");
        System.out.println("3. 과일 가격 수정");
        System.out.println("4. 과일 재고 확인");
        System.out.println("선택 : ");
        int choice = Integer.parseInt(scan.nextLine());

        switch (choice) {
            case 1:
                insertfruit();
                break;
            case 2:
                deletefruit();
            case 3:
                updatefruit();
                break;
            case 4:
                readfruit();

        }

    }


    public void insertfruit(){
            System.out.println("추가할 과일 : ");
            String fruit = scan.nextLine();
            System.out.println("수량 : ");
            int count = scan.nextInt();
            scan.nextLine();
            System.out.println("가격 : ");
            int price = scan.nextInt();
            scan.nextLine();

            Dto store = new Dto(fruit, count, price);
            service.insertfruitcheck(store);
            mainMenu();
    }

    public void deletefruit(){
        System.out.print("삭제할 과일 : ");
        String fruit = scan.nextLine();

        service.deletefruit(fruit);
        mainMenu();
    }

    public void updatefruit(){
        System.out.println("수정할 과일 이름 : ");
        String fruit = scan.nextLine();
        System.out.println("새로운 가격 : ");
        int price = Integer.parseInt(scan.nextLine());

        Dto updateDto = new Dto(fruit, null ,price);
        service.updatefruit(updateDto);
        mainMenu();
    }

    public void readfruit(){
        System.out.println("재고 확인 과일 이름 : ");
        String fruit = scan.nextLine();
        Dto dto = new Dto(fruit, null ,0);
        Dto read = service.readfruit(dto);
        System.out.println("과일 이름 : " + read.getFruit());
        System.out.println("수량 : " + read.getCount());
        System.out.println("가격 : " + read.getPrice());
        mainMenu();

    }


    public void menu(){
        System.out.println("1. 과일 추가");
        System.out.println("2. 과일 삭제");
        System.out.println("3. 과일 가격 수정");
        System.out.println("4. 과일 재고 확인");
        System.out.println("선택 : ");
    }





    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.mainMenu();
    }






}
