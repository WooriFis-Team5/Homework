package week1.test;

class Bird {
    public void fly() {
        System.out.println("새가 날아다닙니다.");
    }
}

class Hawk extends Bird {
    @Override
    public void fly(){
        System.out.println("독수리가 날아다닙니다.");
    }

    public void hunting(){
        System.out.println("독수리가 사냥합니다.");
    }
}

public class Test {
    public static void main(String[] args) {
        //Test comment
        Hawk hawk = new Hawk();
        // 구현된 클래스를 활용해 업 캐스팅을 이어서 구현하시오.


        // 해당 메소드를 호출하면 어떠한 결과가 나오는지 작성하시오.
        // 업캐스팅한 변수.fly();
        // 업캐스팅한 변수.hunting();

        // 구현된 클래스를 활요해 다운 캐스팅을 이어서 구현하시오


        // 해당 메소드를 호출하면 어떠한 결과가 나오는지 작성하시오.
        // 다운캐스팅한 변수.fly();
        // 다운캐스팅한 변수.hunting();

        // 리스트의 자료형을 Bird로 구현하여 bird_up과 bird_down 을 리스트에 구현하시오.

        // 리스트를 반복문을 통해 fly문을 호출하시오.

        // 예외 문제 1) 발생하는 예외를 기재하시오.
        // Integer.parseInt("d1234");

        // 예외 문제 2) 해당 코드의 오류가 있다면, 오류를 수정하고 수정한 이유를 적으시오.
        /* int[] arr = new int[3];
        *  for(int i = 0; i < 4; i++) {
        *      arr[i] = i;
        *  }
        */
    }
}
