package week2.Kiosk.controller;

import week2.Kiosk.Util.Retry;
import week2.Kiosk.View.InputView;
import week2.Kiosk.domain.Command;
import week2.Kiosk.domain.dto.CommandDto;
import week2.Kiosk.domain.dto.IntoCartDto;
import week2.Kiosk.domain.dto.UploadDto;
import week2.Kiosk.service.KioskService;

import java.util.HashMap;
import java.util.Map;

public class KioskController {
    private final InputView inputView = new InputView();
    private final KioskService kioskService;
    private Map<Command, Runnable> service = new HashMap<>();

    public KioskController(KioskService kioskService) {
        this.kioskService = kioskService;
        service.put(Command.UPLOAD, this::upload);
        service.put(Command.VIEWITEM, this::viewItem);
        service.put(Command.INTOCART, this::intoCart);
        service.put(Command.VIEWCART, this::viewCart);
        service.put(Command.BUY, this::payed);
        service.put(Command.PUTMONEY, this::putMoney);
        service.put(Command.PAYANDRETURN, this::payAndReturn);
    }

    public void run() {
        Command command = readCommand();
        while (command.isNotQuit()) {
            try {
                service.get(command).run();
            } catch (IllegalArgumentException e) {
            }
            command = readCommand();
        }
    }

    public Command readCommand() {
        try {
            CommandDto dto = Retry.execute(inputView::readCommand);
            return Command.from(dto.getCommand());
        } catch (IllegalArgumentException e) {

        }
        return null;
    }
    // 상품을 등록하는 API 구현하시오

    public void upload() {
        UploadDto uploadDto = inputView.readUpload();
        kioskService.upload(uploadDto);
    }
    // 등록된 상품을 카테고리별로 출력해주는 API를 구현하시오

    public void viewItem() {
        kioskService.viewItem();
    }
    // 상품을 장바구니에 넣는 API 기능을 구현하시오

    public void intoCart() {
        IntoCartDto intoCartDto = inputView.readIntoCartItem();
        kioskService.intoCart(intoCartDto);
    }
    // 현재 장바구니에 들어있는 상품들을 보여주는 API 기능을 구현하시오.

    public void viewCart() {
        kioskService.viewCart();
    }
    // 장바구니에 있는 상품 전체들을 결제하기 위해 얼마가 필요한지 알려주는 API 기능을 구현하시오.
    // 결과를 알려준 후 프로그램 종료합니다.

    public void payed() {
        kioskService.totalAmount();
    }

    // 결제하기 API - 돈 넣기
    public void putMoney() {
        int money = inputView.readMoney();
        kioskService.putMoney(money);
    }


    // 결제 후 잔액 반환 API
    public void payAndReturn() {
        kioskService.payAndReturn();
    }
}
