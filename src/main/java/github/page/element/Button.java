package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;

public class Button {
    private WebElement button;

    public Button() {}

    public Button(WebElement button) {
        this.button = button;
    }

    public WebElement getButton() {
        return button;
    }

    public BaseRouter click() {
        if (this.button != null) {
            this.button.click();
        }
        return new BaseRouter();
    }
}
