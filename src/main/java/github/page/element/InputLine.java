package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;

public class InputLine {
    private final WebElement input;

    public InputLine(WebElement input) {
        this.input = input;
    }

    public WebElement getInput() {
        return input;
    }

    public BaseRouter fill(String value) {
        input.sendKeys(value);
        return new BaseRouter();
    }
}
