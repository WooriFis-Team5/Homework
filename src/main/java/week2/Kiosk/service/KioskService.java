package week2.Kiosk.service;

import week2.Kiosk.domain.*;
import week2.Kiosk.domain.dto.IntoCartDto;
import week2.Kiosk.domain.dto.UploadDto;
import week2.Kiosk.repository.KioskRepository;

import java.util.*;
import java.util.stream.Collectors;

public class KioskService {
    private final KioskRepository kioskRepository;

    public KioskService(KioskRepository kioskRepository) {
        this.kioskRepository = kioskRepository;
    }

    public void upload(UploadDto dto) {
        String[] info = dto.getUploadInfo().split(", ");
        try {
            kioskRepository.upload(Category.from(info[0]), info[1], Integer.parseInt(info[2]));
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    public void viewItem() {
        Map<Category, List<Item>> itemMap = kioskRepository.viewItem();
        for (Category key : itemMap.keySet()) {
            System.out.println(key.getCategory());
            int i = 1;
            for (Item value : itemMap.get(key)) {
                System.out.println(i++ + ". " + value.toString());
            }
            System.out.println();
        }
    }

    public void intoCart(IntoCartDto dto) {
        List<String> orders = isSomeOrder(dto.getOrders());

        for (String order : orders) {
            try {
                String[] info = order.split(", ");
                kioskRepository.intoCart(Category.from(info[0]), info[1]);
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    public List<String> isSomeOrder(String info) {
        if (info.contains("|")) {
            String[] orders = info.split("[|]");

            return Arrays.stream(orders).collect(Collectors.toList());
        }

        return new ArrayList<>(List.of(info));
    }

    public void viewCart() {
        List<Item> cart = kioskRepository.getCart();

        System.out.println();
        for (Item item : cart) {
            System.out.println(item.toString());
        }
    }

    public void totalAmount() {
        List<Item> cart = kioskRepository.getCart();
        int amount = 0;

        for (Item item : cart) {
            Category category = kioskRepository.getType(item);

            amount += getItemPrice(category, item);
        }
        System.out.println("장바구니 총 금액은 : " + amount);
    }

    public int getItemPrice(Category type, Item item) {
        switch (type){
            case CLOTHES:
                return ((Clothes) item).getPrice();
            case BAG:
                return ((Bag) item).getPrice();
            case FOOD:
                return ((Food) item).getPrice();
            case BEVERAGE:
                return ((Beverage) item).getPrice();
        }
        return -1;
    }
}
