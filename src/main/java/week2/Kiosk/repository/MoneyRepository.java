package week2.Kiosk.repository;

import lombok.Getter;

@Getter
public class MoneyRepository {
    private int money;

    public MoneyRepository() {
        this.money = 0;
    }

    public void putMoney(int putMoney) {
        this.money += putMoney;
    }

    public int returnMoney(int totalAmount) {
        int returnMoney = this.money -  totalAmount;
        this.money = 0;

        return returnMoney;
    }

}
