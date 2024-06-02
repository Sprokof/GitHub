package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;

import java.util.List;

public record CheckBox(List<WebElement> checkBoxes) {

    public BaseRouter check(int index) {
        this.checkBoxes.get(index).click();
        return new BaseRouter();
    }
}
