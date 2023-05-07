package week2.Kiosk.Util;


public class Print {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    public static void gameStart() {
        System.out.println(BLUE + "\n================");
        System.out.println(BLUE + "기능을 선택하세요.");
        System.out.println(BLUE + "0. 상품 등록");
        System.out.println(BLUE + "1. 상품 보기");
        System.out.println(BLUE + "2. 장바구니 상품 추가하기");
        System.out.println(BLUE + "3. 장바구니 상품들 보기");
        System.out.println(BLUE + "4. 필요한 결제 금액 보기");
        System.out.println(BLUE + "5. 돈 넣기");
        System.out.println(BLUE + "6. 결제 및 반환");
        System.out.println(BLUE + "Q. 종료");
        System.out.println(BLUE + "================");
        System.out.print(GREEN + "원하시는 명령어를 작성해주세요 : ");
    }
}