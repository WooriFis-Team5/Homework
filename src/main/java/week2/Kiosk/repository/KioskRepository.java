package week2.Kiosk.repository;

import lombok.Getter;
import week2.Kiosk.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class KioskRepository {
    private final Map<Category, List<Item>> repo = new HashMap<>();
    private final List<Item> cart = new ArrayList<>();

    public KioskRepository() {
        repo.put(Category.CLOTHES, new ArrayList<>());
        repo.put(Category.FOOD, new ArrayList<>());
        repo.put(Category.BEVERAGE, new ArrayList<>());
        repo.put(Category.BAG, new ArrayList<>());

        /*// Test를 위한 코드
        repo.get(Category.CLOTHES).add(new Clothes("청바지", 54000));
        repo.get(Category.BEVERAGE).add(new Beverage("아메리카노", 1500));
        repo.get(Category.FOOD).add(new Food("팟타이", 15000));
        repo.get(Category.FOOD).add(new Food("우동", 10000));*/
    }

    public void upload(Category type, String name, int price) {
        switch (type) {
            case CLOTHES:
                repo.get(type).add(new Clothes(name, price));
                break;
            case BAG:
                repo.get(type).add(new Bag(name, price));
                break;
            case FOOD:
                repo.get(type).add(new Food(name, price));
                break;
            case BEVERAGE:
                repo.get(type).add(new Beverage(name, price));
                break;
        }
    }

    public Map<Category, List<Item>> viewItem() {
        return repo;
    }

    public void intoCart(Category type, String name) {
        Item item = findByName(type, name);
        cart.add(item);
    }

    public Item findByName(Category type, String name) {
        return repo.get(type).stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 상품은 존재하지 않습니다."));
    }

    public Category getType(Item item) {
        for(Category type : repo.keySet()){
            if(repo.get(type).contains(item)){
                return type;
            }
        }

        return null;
    }
}
