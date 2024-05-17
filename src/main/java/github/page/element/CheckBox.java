package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {
    private final List<WebElement> checkBoxes;

    public CheckBox(List<WebElement> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public BaseRouter check(int index) {
        this.checkBoxes.get(index).click();
        return new BaseRouter();
    }
}
