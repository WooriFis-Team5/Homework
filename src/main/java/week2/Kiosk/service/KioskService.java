package week2.Kiosk.service;

import week2.Kiosk.domain.Category;
import week2.Kiosk.domain.Item;
import week2.Kiosk.domain.dto.UploadDto;
import week2.Kiosk.repository.KioskRepository;

import java.util.List;
import java.util.Map;

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
            for (Item value : itemMap.get(key)){
                System.out.println(i++ + ". " + value.toString());
            }
            System.out.println();
        }
    }
}
