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

    public Item findByName(Category type, String name) {
        return repo.get(type).stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 상품은 존재하지 않습니다."));
    }
}
