package week2.Kiosk.repository;

import lombok.Getter;

@Getter
public class MoneyRepository {
    private int money;

    public MoneyRepository() {
        this.money = 0;
    }

    public void putMoney(int putMoney){
        this.money += putMoney;
        System.out.println();
    }
}
