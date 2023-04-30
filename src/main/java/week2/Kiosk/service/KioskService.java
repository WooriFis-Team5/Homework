package week2.Kiosk.service;

import week2.Kiosk.domain.Category;
import week2.Kiosk.domain.dto.UploadDto;
import week2.Kiosk.repository.KioskRepository;

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
}
