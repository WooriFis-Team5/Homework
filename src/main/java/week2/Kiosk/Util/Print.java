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
        System.out.println(BLUE + "Q. 종료");
        System.out.println(BLUE + "================");
        System.out.print(GREEN + "원하시는 명령어를 작성해주세요 : ");
    }

    public static void categoryType() {
        System.out.println(YELLOW + "\n================");
        System.out.println(PURPLE + "키오스크의 상품 타입 종류는 음식, 음료, 의류, 가방이 있습니다.");
        System.out.println(PURPLE + "원하시는 상품 타입과 이름, 가격 순으로 입력해주세요.");
        System.out.println(YELLOW + "================");
        System.out.print(GREEN + "등록하실 상품을 작성해주세요 : ");
    }

    public static void intoCartItem() {
        System.out.println(YELLOW + "\n================");
        System.out.println(PURPLE + "장바구니에 넣을 상품을 상품 타입, 이름 순으로 입력해주세요.");
        System.out.println(PURPLE + "다중 아이템을 선택할 시 '|'을 아이템 사이에 넣어주세요.");
        System.out.println(YELLOW + "================");
        System.out.print(GREEN + "장바구니에 담으실 상품명을 작성해주세요 : ");
    }
}
