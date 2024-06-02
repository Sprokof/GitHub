package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;

public record InputLine(WebElement input) {

    public BaseRouter fill(String value) {
        input.sendKeys(value);
        return new BaseRouter();
    }
}
