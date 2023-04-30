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
    }

    public void upload(Category category, String name, int price) {
        switch (category) {
            case CLOTHES:
                repo.get(category).add(new Clothes(name, price));
                break;
            case BAG:
                repo.get(category).add(new Bag(name, price));
                break;
            case FOOD:
                repo.get(category).add(new Food(name, price));
                break;
            case BEVERAGE:
                repo.get(category).add(new Beverage(name, price));
                break;
        }
    }

    public Map<Category, List<Item>> viewItem() {
        return repo;
    }
}
