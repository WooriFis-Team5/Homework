package week2.Kiosk.View;

import week2.Kiosk.Util.Print;
import week2.Kiosk.domain.dto.CommandDto;
import week2.Kiosk.domain.dto.IntoCartDto;
import week2.Kiosk.domain.dto.UploadDto;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    // 기능 구현
    public CommandDto readCommand() {
        Print.gameStart();

        String command = sc.nextLine().toUpperCase();
        return new CommandDto(command);
    }

    public UploadDto readUpload() {
        Print.categoryType();
        String uploadInfo = sc.nextLine();

        return new UploadDto(uploadInfo);
    }

    public IntoCartDto readIntoCartItem() {
        Print.intoCartItem();
        String intoCartDto = sc.nextLine();

        return new IntoCartDto(intoCartDto);
    }
}
